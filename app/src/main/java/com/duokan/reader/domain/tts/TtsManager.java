package com.duokan.reader.domain.tts;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.io.FileUtil;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ag;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0563j;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.C0659k;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.WebSession.CacheStrategy;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.downloadcenter.C0780k;
import com.duokan.reader.domain.downloadcenter.C1014m;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.domain.downloadcenter.DownloadType;
import com.duokan.reader.domain.downloadcenter.ab;
import com.duokan.reader.domain.social.p048b.C1134a;
import com.iflytek.cloud.util.ResourceUtil;
import com.iflytek.cloud.util.ResourceUtil.RESOURCE_TYPE;
import com.iflytek.speech.VoiceWakeuperAidl;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TtsManager implements ai, C0563j, C0586j, C0780k {
    private static final String BASE_RESOURCE_DOWNLOADED = "base_resource_downloaded";
    private static final String CURRENT_SPEAKER = "current_speaker";
    private static final String CURRENT_SPEAKER_FOR_IFLYTEK = "current_speaker_for_iflytek";
    private static final long DEFAULT_VOICE_SIZE = 4810177;
    private static final String SPEAKER_LIST = "speaker_list";
    private static final String SPEAKER_LIST_FOR_IFLYTEK = "speaker_list_for_iflytek";
    private static final String TTS_APP_KEY = "597a9476";
    private static final String TTS_PROVIDER = "xunfei";
    private static final String TTS_USER_NOTIFIED = "tts_user_notified";
    private static final C0657i TTS_WEBSESSION_CONFIG = new C0659k().m3096a(TTS_PROVIDER).m3095a(CacheStrategy.USE_CACHE_IF_FRESH).m3098b(CacheStrategy.USE_CACHE_IF_FRESH).m3094a();
    private static final aj<TtsManager> sWrapper = new aj();
    private final C0709k mAccountManager;
    private SharedPreferences mCommonPrefs = null;
    private final Context mContext;
    private final CopyOnWriteArrayList<OnCurrentSpeakerChangeListener> mCurrentSpeakerChangeListeners;
    private final TtsSpeaker mDefaultSpeaker;
    private final C1016b mDownloadCenter;
    private final CopyOnWriteArrayList<OnUserIdChangeListener> mOnUserIdChangeListeners;
    private final PersonalPrefs mPersonalPrefs;
    private WebSession mRequireUserIdSession = null;
    private final File mTtsFileDir;
    private String mTtsUserId = "";

    /* renamed from: com.duokan.reader.domain.tts.TtsManager$1 */
    class C12101 implements Runnable {
        C12101() {
        }

        public void run() {
            TtsManager.this.queryTtsUserId(null);
        }
    }

    public interface OnCurrentSpeakerChangeListener {
        void onCurrentSpeakerChange();
    }

    public interface OnUserIdChangeListener {
        void onUserIdChange(String str);
    }

    public class TtsSpeaker {
        public String mEngineType = "";
        public String mEnt = "";
        public String mField = "";
        public String mId = "";
        public String mName = "";
        public String mNickname = "";
        public long mResSize = 0;
        public String mSpeakerPath = "";
        public String mUserIcon = "";

        public TtsSpeaker(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.mId = jSONObject.optString("speakerId");
                this.mName = jSONObject.optString("name");
                this.mNickname = jSONObject.optString("nickname");
                this.mSpeakerPath = jSONObject.optString("speaker_path");
                this.mEngineType = jSONObject.optString("engineType");
                this.mField = jSONObject.optString("field");
                this.mUserIcon = jSONObject.optString("smallIcon");
                this.mEnt = jSONObject.optString("ent");
                this.mResSize = jSONObject.optLong("resSize");
            } catch (Throwable th) {
            }
        }

        public String toString() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("speakerId", this.mId);
                jSONObject.put("name", this.mName);
                jSONObject.put("nickname", this.mNickname);
                jSONObject.put("speaker_path", this.mSpeakerPath);
                jSONObject.put("engineType", this.mEngineType);
                jSONObject.put("field", this.mField);
                jSONObject.put("smallIcon", this.mUserIcon);
                jSONObject.put("ent", this.mEnt);
                jSONObject.put("resSize", this.mResSize);
                return jSONObject.toString();
            } catch (Throwable th) {
                return "";
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof TtsSpeaker)) {
                return false;
            }
            TtsSpeaker ttsSpeaker = (TtsSpeaker) obj;
            if (ttsSpeaker.mEngineType.equals(this.mEngineType) && ttsSpeaker.mName.equals(this.mName)) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.mName);
        }

        public boolean isCloud() {
            return this.mEngineType.equals("cloud");
        }

        public boolean isAdded() {
            TtsManager ttsManager = TtsManager.get();
            if (ttsManager == null) {
                return false;
            }
            Iterator it = ttsManager.getSpeakerList().iterator();
            while (it.hasNext()) {
                if (equals((TtsSpeaker) it.next())) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void startup(Context context, C0709k c0709k, PersonalPrefs personalPrefs, C1016b c1016b, C0559f c0559f) {
        sWrapper.m709a(new TtsManager(context, c0709k, personalPrefs, c1016b, c0559f));
    }

    public static TtsManager get() {
        return (TtsManager) sWrapper.m707a();
    }

    private TtsManager(Context context, C0709k c0709k, PersonalPrefs personalPrefs, C1016b c1016b, C0559f c0559f) {
        this.mContext = context;
        this.mTtsFileDir = new File(DkApp.get().getFilesDir(), "/ttsDir");
        this.mDefaultSpeaker = new TtsSpeaker("{\"accent\":\"普通话\",\"age\":24,\"appid\":\"597a9476\",\"commonExpirationDate\":\"\",\"description\":\"\",\"downloads\":0,\"engineType\":\"local\",\"engineVersion\":1,\"ent\":\"\",\"experienceExpirationDate\":\"\",\"field\":\"普通发音人\",\"isActive\":1,\"isDefault\":0,\"isNew\":0,\"isRecommend\":0,\"isVip\":0,\"largeIcon\":\"https:\\/\\/bj.openstorage.cn\\/v1\\/iflytek\\/tts\\/common\\/icon\\/xiaoyan_big.png\",\"level\":0,\"listenPath\":\"aHR0cHM6Ly9iai5vcGVuc3RvcmFnZS5jbi92MS9pZmx5dGVrL3R0cy9jb21tb24vbGlzdGVuL3hpYW95YW4ubXAz\",\"name\":\"xiaoyan\",\"nickname\":\"王老师\",\"price\":0,\"resId\":712,\"resPath\":\"\",\"resSize\":2065412,\"sex\":\"female\",\"smallIcon\":\"https:\\/\\/bj.openstorage.cn\\/v1\\/iflytek\\/tts\\/common\\/icon\\/xiaoyan_small.png\",\"sortId\":11,\"speakerId\":3,\"updateTime\":\"\",\"version\":1}");
        this.mAccountManager = c0709k;
        this.mPersonalPrefs = personalPrefs;
        this.mDownloadCenter = c1016b;
        this.mAccountManager.m3494a((C0586j) this);
        this.mDownloadCenter.m7872a((C0780k) this);
        c0559f.m2481a((C0563j) this);
        this.mCurrentSpeakerChangeListeners = new CopyOnWriteArrayList();
        this.mOnUserIdChangeListeners = new CopyOnWriteArrayList();
        DkApp.get().runWhenUiReady(new C12101());
    }

    public void onTaskRunning(DownloadCenterTask downloadCenterTask) {
    }

    public void onTaskStatusChanged(DownloadCenterTask downloadCenterTask) {
        C1014m p = downloadCenterTask.m7802p();
        if (p.mo1474a() != DownloadType.TTS_PACK) {
            return;
        }
        if (downloadCenterTask.m7794h() || downloadCenterTask.m7793g()) {
            TtsSpeaker ttsSpeaker = new TtsSpeaker(((ab) p).m7827d().toString());
            String ttsFileUri = getTtsFileUri(ttsSpeaker);
            if (downloadCenterTask.m7794h() && !TextUtils.isEmpty(ttsFileUri)) {
                FileUtil.deleteFile(new File(ttsFileUri));
            } else if (!ttsSpeaker.mId.equals(String.valueOf(-1))) {
                ttsSpeaker.mSpeakerPath = generateSpeakerPath(ttsFileUri + "/" + ttsSpeaker.mName + ".jet");
                addSpeaker(ttsSpeaker);
                setCurrentSpeaker(ttsSpeaker);
            }
            C1016b.m7857p().m7887d(downloadCenterTask);
        }
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        queryTtsUserId(null);
    }

    public void onAccountLogoff(C0672a c0672a) {
        if (this.mRequireUserIdSession != null) {
            this.mRequireUserIdSession.close();
            this.mRequireUserIdSession = null;
        }
        this.mDownloadCenter.m7874a(this.mDownloadCenter.m7895k());
        this.mTtsUserId = "";
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }

    public void onConnectivityChanged(C0559f c0559f) {
        if (C0559f.m2476b().m2486e()) {
            queryTtsUserId(null);
        }
    }

    public String getTtsAppKey() {
        return TTS_APP_KEY;
    }

    public long getDefaultPackSize() {
        return DEFAULT_VOICE_SIZE;
    }

    public void addCurrentSpeakerChangeListener(OnCurrentSpeakerChangeListener onCurrentSpeakerChangeListener) {
        this.mCurrentSpeakerChangeListeners.add(onCurrentSpeakerChangeListener);
    }

    public void removeOnCurrentSpeakerChangeListener(OnCurrentSpeakerChangeListener onCurrentSpeakerChangeListener) {
        this.mCurrentSpeakerChangeListeners.remove(onCurrentSpeakerChangeListener);
    }

    public void addOnUserIdChangeListener(OnUserIdChangeListener onUserIdChangeListener) {
        this.mOnUserIdChangeListeners.add(onUserIdChangeListener);
    }

    public void removeOnUserIdChangeListener(OnUserIdChangeListener onUserIdChangeListener) {
        this.mOnUserIdChangeListeners.remove(onUserIdChangeListener);
    }

    public TtsSpeaker getDefaultSpeaker() {
        return this.mDefaultSpeaker;
    }

    public String getTtsUserId() {
        return this.mTtsUserId;
    }

    public void queryTtsUserId(final ag<String> agVar) {
        if (TextUtils.isEmpty(this.mTtsUserId)) {
            if (this.mRequireUserIdSession != null) {
                this.mRequireUserIdSession.close();
            }
            if (this.mAccountManager.m3507c()) {
                this.mRequireUserIdSession = new WebSession(TTS_WEBSESSION_CONFIG) {
                    C0621a<String> result = new C0621a();

                    protected void onSessionTry() {
                        this.result = new C1134a(this, TtsManager.this.mAccountManager.m3508d()).m8458g(TtsManager.TTS_PROVIDER);
                    }

                    protected void onSessionSucceeded() {
                        if (this.result.b == 0) {
                            if (!((String) this.result.f2058a).equals(TtsManager.this.mTtsUserId)) {
                                Iterator it = TtsManager.this.mOnUserIdChangeListeners.iterator();
                                while (it.hasNext()) {
                                    ((OnUserIdChangeListener) it.next()).onUserIdChange((String) this.result.f2058a);
                                }
                            }
                            TtsManager.this.mTtsUserId = (String) this.result.f2058a;
                            if (agVar != null) {
                                agVar.run(TtsManager.this.mTtsUserId);
                            }
                        } else if (agVar != null) {
                            agVar.run("");
                        }
                    }

                    protected void onSessionFailed() {
                        if (agVar != null) {
                            agVar.run("");
                        }
                    }

                    protected void onSessionClosed() {
                        super.onSessionClosed();
                        TtsManager.this.mRequireUserIdSession = null;
                    }
                };
                this.mRequireUserIdSession.open();
                return;
            }
            UThread.runOnThread(new Runnable() {
                public void run() {
                    if (agVar != null) {
                        agVar.run("");
                    }
                }
            });
            return;
        }
        UThread.runOnThread(new Runnable() {
            public void run() {
                if (agVar != null) {
                    agVar.run(TtsManager.this.mTtsUserId);
                }
            }
        });
    }

    public String getEncryptUserId(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (byte toHexString : str.getBytes("utf-8")) {
                stringBuilder.append(Integer.toHexString(toHexString));
            }
            return new BigInteger(stringBuilder.toString(), 16).toString(32);
        } catch (Throwable th) {
            return "";
        }
    }

    public File getTtsDir() {
        return this.mTtsFileDir;
    }

    public synchronized void setCurrentSpeaker(TtsSpeaker ttsSpeaker) {
        TtsSpeaker ttsSpeaker2 = new TtsSpeaker(getAccountPrefs().getString(CURRENT_SPEAKER, ""));
        if ((ttsSpeaker.isEmpty() || ttsSpeaker.isAdded()) && !ttsSpeaker2.equals(ttsSpeaker)) {
            Editor edit = getAccountPrefs().edit();
            edit.putString(CURRENT_SPEAKER, ttsSpeaker.toString());
            edit.apply();
            Iterator it = this.mCurrentSpeakerChangeListeners.iterator();
            while (it.hasNext()) {
                ((OnCurrentSpeakerChangeListener) it.next()).onCurrentSpeakerChange();
            }
        }
    }

    public synchronized TtsSpeaker getCurrentSpeaker() {
        TtsSpeaker ttsSpeaker;
        ttsSpeaker = new TtsSpeaker(getAccountPrefs().getString(CURRENT_SPEAKER, ""));
        if (!(ttsSpeaker.isEmpty() || ttsSpeaker.isAdded())) {
            if (getSpeakerList().isEmpty()) {
                ttsSpeaker = new TtsSpeaker("");
            } else {
                ttsSpeaker = (TtsSpeaker) getSpeakerList().getFirst();
            }
            Editor edit = getAccountPrefs().edit();
            edit.putString(CURRENT_SPEAKER, ttsSpeaker.toString());
            edit.apply();
        }
        return ttsSpeaker;
    }

    public synchronized void addSpeaker(TtsSpeaker ttsSpeaker) {
        if (!(ttsSpeaker.isEmpty() || ttsSpeaker.isAdded())) {
            try {
                SharedPreferences accountPrefs;
                JSONArray jSONArray;
                if (ttsSpeaker.mEngineType.equals("cloud")) {
                    accountPrefs = getAccountPrefs();
                } else {
                    accountPrefs = getCommonPrefs();
                }
                Object string = accountPrefs.getString(SPEAKER_LIST, "");
                if (TextUtils.isEmpty(string)) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(string);
                }
                jSONArray.put(ttsSpeaker.toString());
                Editor edit = accountPrefs.edit();
                edit.putString(SPEAKER_LIST, jSONArray.toString());
                edit.apply();
            } catch (Throwable th) {
            }
        }
    }

    public boolean removeSpeakers(List<TtsSpeaker> list) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (TtsSpeaker ttsSpeaker : list) {
            if (ttsSpeaker.isAdded()) {
                if (ttsSpeaker.mEngineType.equals("cloud")) {
                    arrayList.add(ttsSpeaker);
                } else {
                    arrayList2.add(ttsSpeaker);
                }
            }
        }
        return removeSpeakers(true, arrayList) && removeSpeakers(false, arrayList2);
    }

    public synchronized void setSpeakerList(boolean z, LinkedList<TtsSpeaker> linkedList) {
        SharedPreferences accountPrefs;
        if (z) {
            accountPrefs = getAccountPrefs();
        } else {
            accountPrefs = getCommonPrefs();
        }
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                jSONArray.put(((TtsSpeaker) it.next()).toString());
            }
            Editor edit = accountPrefs.edit();
            edit.putString(SPEAKER_LIST, jSONArray.toString());
            edit.apply();
        } catch (Throwable th) {
        }
    }

    public synchronized LinkedList<TtsSpeaker> getSpeakerList() {
        LinkedList<TtsSpeaker> linkedList;
        linkedList = new LinkedList();
        linkedList.addAll(getLocalSpeakerList());
        linkedList.addAll(getCloudSpeakerList());
        return linkedList;
    }

    public synchronized void setSpeakerListForIflytek(String str) {
        Editor edit = getCommonPrefs().edit();
        edit.putString(SPEAKER_LIST_FOR_IFLYTEK, str);
        edit.apply();
    }

    public synchronized String getSpeakerListForIflytek() {
        return getCommonPrefs().getString(SPEAKER_LIST_FOR_IFLYTEK, "");
    }

    public synchronized String getCurrentSpeakerForIflytek() {
        String jSONObject;
        int i = 0;
        synchronized (this) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                Object string = getAccountPrefs().getString(CURRENT_SPEAKER_FOR_IFLYTEK, "");
                Object string2 = getCommonPrefs().getString(CURRENT_SPEAKER_FOR_IFLYTEK, "");
                JSONArray jSONArray2 = TextUtils.isEmpty(string) ? new JSONArray() : new JSONArray(string);
                JSONArray jSONArray3 = TextUtils.isEmpty(string2) ? new JSONArray() : new JSONArray(string2);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    jSONArray.put(jSONArray2.getJSONObject(i2));
                }
                while (i < jSONArray3.length()) {
                    jSONArray.put(jSONArray3.getJSONObject(i));
                    i++;
                }
                jSONObject2.put("ver", "1");
                jSONObject2.put("info", jSONArray);
                jSONObject = jSONObject2.toString();
            } catch (Throwable th) {
                jSONObject = "";
            }
        }
        return jSONObject;
    }

    public synchronized boolean addSelectedSpeaker(String str) {
        boolean z = true;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                SharedPreferences accountPrefs;
                TtsSpeaker ttsSpeaker = new TtsSpeaker(str);
                if (ttsSpeaker.mEngineType.equals("cloud")) {
                    accountPrefs = getAccountPrefs();
                } else {
                    accountPrefs = getCommonPrefs();
                }
                try {
                    JSONArray jSONArray;
                    Object string = accountPrefs.getString(CURRENT_SPEAKER_FOR_IFLYTEK, "");
                    if (TextUtils.isEmpty(string)) {
                        jSONArray = new JSONArray();
                    } else {
                        jSONArray = new JSONArray(string);
                    }
                    String str2 = ttsSpeaker.mName;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject.get("name").equals(str2) && jSONObject.optString("engineType").equals(ttsSpeaker.mEngineType)) {
                            jSONArray.remove(i);
                        }
                    }
                    jSONArray.put(new JSONObject(str));
                    Editor edit = accountPrefs.edit();
                    edit.putString(CURRENT_SPEAKER_FOR_IFLYTEK, jSONArray.toString());
                    edit.apply();
                } catch (JSONException e) {
                    e.printStackTrace();
                    z = false;
                }
            }
        }
        return z;
    }

    public synchronized boolean removeSelectedSpeaker(String str) {
        boolean z = true;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                SharedPreferences accountPrefs;
                TtsSpeaker ttsSpeaker = new TtsSpeaker(str);
                if (ttsSpeaker.mEngineType.equals("cloud")) {
                    accountPrefs = getAccountPrefs();
                } else {
                    accountPrefs = getCommonPrefs();
                }
                try {
                    JSONArray jSONArray;
                    Object string = accountPrefs.getString(CURRENT_SPEAKER_FOR_IFLYTEK, "");
                    if (TextUtils.isEmpty(string)) {
                        jSONArray = new JSONArray();
                    } else {
                        jSONArray = new JSONArray(string);
                    }
                    String str2 = ttsSpeaker.mName;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject.get("name").equals(str2) && jSONObject.optString("engineType").equals(ttsSpeaker.mEngineType)) {
                            jSONArray.remove(i);
                        }
                    }
                    Editor edit = accountPrefs.edit();
                    edit.putString(CURRENT_SPEAKER_FOR_IFLYTEK, jSONArray.toString());
                    edit.apply();
                } catch (JSONException e) {
                    e.printStackTrace();
                    z = false;
                }
            }
        }
        return z;
    }

    public synchronized String getTtsFileUri(TtsSpeaker ttsSpeaker) {
        String absolutePath;
        if (ttsSpeaker != null) {
            if (!TextUtils.isEmpty(ttsSpeaker.mName)) {
                if (this.mTtsFileDir.exists() || this.mTtsFileDir.mkdirs()) {
                    absolutePath = new File(this.mTtsFileDir, ttsSpeaker.mName).getAbsolutePath();
                } else {
                    absolutePath = "";
                }
            }
        }
        absolutePath = "";
        return absolutePath;
    }

    public synchronized boolean isBaseResourceDownloaded() {
        return getCommonPrefs().getBoolean(BASE_RESOURCE_DOWNLOADED, false);
    }

    public synchronized void setBaseResourceDownloaded(boolean z) {
        Editor edit = getCommonPrefs().edit();
        edit.putBoolean(BASE_RESOURCE_DOWNLOADED, z);
        edit.apply();
    }

    public synchronized boolean isTtsUserNotified() {
        return getCommonPrefs().getBoolean(TTS_USER_NOTIFIED, false);
    }

    public synchronized void setTtsUserNotified(boolean z) {
        Editor edit = getCommonPrefs().edit();
        edit.putBoolean(TTS_USER_NOTIFIED, z);
        edit.apply();
    }

    public synchronized boolean isEventExpired() {
        return new GregorianCalendar().after(new GregorianCalendar(2018, 3, 8, 0, 0, 0));
    }

    private SharedPreferences getAccountPrefs() {
        return this.mPersonalPrefs.m5244t();
    }

    private SharedPreferences getCommonPrefs() {
        if (this.mCommonPrefs == null) {
            String str = "tts-prefs";
            this.mCommonPrefs = this.mContext.getSharedPreferences("tts-prefs", 0);
        }
        return this.mCommonPrefs;
    }

    public String generateSpeakerPath(String str) {
        String str2 = "";
        if (!this.mTtsFileDir.exists() && !this.mTtsFileDir.mkdirs()) {
            return "";
        }
        File file = new File(this.mTtsFileDir.getAbsolutePath() + "/common/common.jet");
        if (!file.exists() || !file.isFile()) {
            return "";
        }
        str2 = str2 + ResourceUtil.generateResourcePath(this.mContext, RESOURCE_TYPE.path, file.getAbsolutePath());
        file = new File(str);
        if (file.exists() && file.isFile()) {
            return str2 + VoiceWakeuperAidl.PARAMS_SEPARATE + ResourceUtil.generateResourcePath(this.mContext, RESOURCE_TYPE.path, str);
        }
        return "";
    }

    private boolean removeSpeakers(boolean z, List<TtsSpeaker> list) {
        if (list.size() == 0) {
            return true;
        }
        SharedPreferences accountPrefs;
        if (z) {
            accountPrefs = getAccountPrefs();
        } else {
            accountPrefs = getCommonPrefs();
        }
        String str = getCurrentSpeaker().mName;
        Object obj = null;
        try {
            JSONArray jSONArray;
            Object string = accountPrefs.getString(CURRENT_SPEAKER_FOR_IFLYTEK, "");
            if (TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(string);
            }
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                string = null;
                for (TtsSpeaker ttsSpeaker : list) {
                    Object obj2;
                    if (ttsSpeaker.mName.equals(jSONObject.getString("name"))) {
                        if (obj == null && str.equals(ttsSpeaker.mName)) {
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                        obj2 = 1;
                    } else {
                        obj2 = string;
                    }
                    string = obj2;
                }
                if (string == null) {
                    jSONArray2.put(jSONObject);
                }
            }
            LinkedList cloudSpeakerList = z ? getCloudSpeakerList() : getLocalSpeakerList();
            cloudSpeakerList.removeAll(list);
            setSpeakerList(z, cloudSpeakerList);
            Editor edit = accountPrefs.edit();
            edit.putString(CURRENT_SPEAKER_FOR_IFLYTEK, jSONArray2.toString());
            edit.apply();
            if (obj != null) {
                cloudSpeakerList = getSpeakerList();
                setCurrentSpeaker(cloudSpeakerList.isEmpty() ? new TtsSpeaker("") : (TtsSpeaker) cloudSpeakerList.getFirst());
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public LinkedList<TtsSpeaker> getLocalSpeakerList() {
        LinkedList<TtsSpeaker> linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(getCommonPrefs().getString(SPEAKER_LIST, ""));
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(new TtsSpeaker(jSONArray.getString(i)));
            }
        } catch (Throwable th) {
        }
        return linkedList;
    }

    public LinkedList<TtsSpeaker> getCloudSpeakerList() {
        LinkedList<TtsSpeaker> linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(getAccountPrefs().getString(SPEAKER_LIST, ""));
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(new TtsSpeaker(jSONArray.getString(i)));
            }
        } catch (Throwable th) {
        }
        return linkedList;
    }
}

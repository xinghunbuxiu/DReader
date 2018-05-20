package com.duokan.reader.ui.general.web;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.io.FileUtil;
import com.duokan.core.sys.C0299i;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.Scrollable.OverScrollMode;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.downloadcenter.C0780k;
import com.duokan.reader.domain.downloadcenter.C1014m;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.downloadcenter.C1025l;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.domain.downloadcenter.DownloadType;
import com.duokan.reader.domain.downloadcenter.ab;
import com.duokan.reader.domain.tts.TtsManager;
import com.duokan.reader.domain.tts.TtsManager.OnUserIdChangeListener;
import com.duokan.reader.domain.tts.TtsManager.TtsSpeaker;
import com.duokan.reader.ui.general.FileTransferPrompter;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.LoadingCircleView;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.reading.su;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class TtsWebController extends StorePageController implements C0780k, OnUserIdChangeListener {
    private static final int CODE_VAL_ERROR = 1;
    private static final int CODE_VAL_SUCCESS = 0;
    private static final String KEY_APPID = "appid";
    private static final String KEY_CODE = "code";
    private static final String KEY_CURRENT_SPEAKER = "currentSpeaker";
    private static final String KEY_DATA = "data";
    private static final String KEY_DEVICE = "device";
    private static final String KEY_IMEI = "imei";
    private static final String KEY_ORDER = "order";
    private static final String KEY_OS = "os";
    private static final String KEY_OS_VERSION = "osVersion";
    private static final String KEY_PROGRESS = "progress";
    private static final String KEY_SPEAKER = "speaker";
    private static final String KEY_TOKEN = "token";
    private static final String KEY_UID = "uid";
    private static final String KEY_USER = "user";
    private static final String TAG_BACK = "tag_back";
    private static final String TAG_DOWNLOAD = "tag_download";
    private static final String TAG_FREE_TRIAL = "tag_free_trial";
    private static final String TAG_GET_DATA = "tag_get_data";
    private static final String TAG_GET_USER = "tag_get_user";
    private static final String TAG_PAUSE_DOWNLOAD = "tag_pause_download";
    private static final String TAG_PAY = "tag_pay";
    private static final String TAG_PUT_DATA = "tag_put_data";
    private static final String TAG_RELOAD = "tag_reload";
    private static final String TAG_REMOVE = "tag_remove";
    private static final String TAG_RESUME_DOWNLOAD = "tag_resume_download";
    private final C1016b mDownloadCenter = C1016b.m7857p();
    private final CopyOnWriteArrayList<C1025l> mFutureDownloadSpeakers = new CopyOnWriteArrayList();
    private final LoadingCircleView mPageLoadingView;
    private final TtsManager mTtsManager = TtsManager.get();

    public TtsWebController(IFeature mFeature) {
        super(mFeature);
        this.mWebRootView.setPadding(this.mWebRootView.getPaddingLeft(), ((su) getContext().queryFeature(su.class)).getTheme().getPageHeaderHeight(), this.mWebRootView.getPaddingRight(), this.mWebRootView.getPaddingBottom());
        this.mPageLoadingView = (LoadingCircleView) findViewById(C0255g.general__web_core_view__first_load);
        this.mPageLoadingView.setVisibility(0);
        this.mWebView.loadUrl(C0641o.m2934i().m2950N());
        this.mWebView.addJavascriptInterface(new lg(), "jsHandler");
        this.mWebView.setVerticalOverScrollMode(OverScrollMode.STRETCH);
        this.mWebView.getSettings().setTextZoom(100);
        setPageTitleLeft(true);
    }

    public String invokeJS(String str, String str2) {
        try {
            if (this.mWebView != null) {
                this.mWebView.loadUrl("javascript:" + str + "(" + (TextUtils.isEmpty(str2) ? "" : "'" + str2 + "'") + ")");
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public void onTaskRunning(DownloadCenterTask downloadCenterTask) {
        C1014m p = downloadCenterTask.m7802p();
        if (p.mo1474a() == DownloadType.TTS_PACK) {
            onProgress(((ab) p).m7827d(), downloadCenterTask.m7796j());
        }
    }

    public void onTaskStatusChanged(DownloadCenterTask downloadCenterTask) {
        C1014m p = downloadCenterTask.m7802p();
        if (p.mo1474a() != DownloadType.TTS_PACK) {
            return;
        }
        if (downloadCenterTask.m7792f()) {
            onDone(((ab) p).m7827d(), downloadCenterTask.m7793g());
            if (!this.mTtsManager.isBaseResourceDownloaded()) {
                this.mTtsManager.setBaseResourceDownloaded(true);
                Iterator it = this.mFutureDownloadSpeakers.iterator();
                while (it.hasNext()) {
                    C1025l c1025l = (C1025l) it.next();
                    if (c1025l.f5084f) {
                        this.mDownloadCenter.m7865a(c1025l);
                        this.mFutureDownloadSpeakers.remove(c1025l);
                    }
                }
            }
        } else if (downloadCenterTask.m7789c()) {
            long m = new TtsSpeaker(((ab) downloadCenterTask.m7802p()).m7827d().toString()).mResSize - downloadCenterTask.m7799m();
            if (m == 0) {
                this.mDownloadCenter.m7879b(downloadCenterTask);
                return;
            }
            Context context = getContext();
            String string = getString(C0258j.reading__tts_web_view__need_data);
            String string2 = getString(C0258j.reading__tts_web_view__data_usage);
            Object[] objArr = new Object[1];
            objArr[0] = m <= 0 ? "" : DkPublic.formatBytes(m);
            FileTransferPrompter.m9977a(context, m, string, String.format(string2, objArr), new kx(this, downloadCenterTask));
        }
    }

    public void onUserIdChange(String str) {
        refresh();
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.mDownloadCenter.m7872a((C0780k) this);
        this.mTtsManager.addOnUserIdChangeListener(this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.mDownloadCenter.m7880b((C0780k) this);
        this.mTtsManager.removeOnUserIdChangeListener(this);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        refresh();
    }

    private String getUserInfo(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject(getDevice());
            jSONObject.put(KEY_APPID, this.mTtsManager.getTtsAppKey());
            jSONObject.put(KEY_USER, jSONObject2);
            jSONObject.put("device", jSONObject3);
            jSONObject2.put(KEY_UID, this.mTtsManager.getEncryptUserId(str));
            jSONObject2.put(KEY_TOKEN, KEY_TOKEN);
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    private String getDevice() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_OS, "android");
            jSONObject.put(KEY_OS_VERSION, VERSION.RELEASE);
        } catch (Throwable th) {
        }
        try {
            jSONObject.put(KEY_IMEI, C0709k.m3476a().m3514i());
        } catch (Throwable th2) {
        }
        return jSONObject.toString();
    }

    private String getSpeakerData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (KEY_SPEAKER.equalsIgnoreCase(jSONObject.getString("param"))) {
                return this.mTtsManager.getSpeakerListForIflytek();
            }
            if (KEY_CURRENT_SPEAKER.equalsIgnoreCase(jSONObject.getString("param"))) {
                return this.mTtsManager.getCurrentSpeakerForIflytek();
            }
            return "";
        } catch (Throwable th) {
            return "";
        }
    }

    private String putSpeakerData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mTtsManager.setSpeakerListForIflytek(str);
        }
        return "";
    }

    private void downloadSpeaker(C0299i<String> c0299i, String str) {
        if (TextUtils.isEmpty(str)) {
            c0299i.m708a("");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            TtsSpeaker ttsSpeaker = new TtsSpeaker(str);
            if (ttsSpeaker.isAdded()) {
                c0299i.m708a(getRetString(str, true));
            } else if ("local".equals(ttsSpeaker.mEngineType)) {
                for (DownloadCenterTask downloadCenterTask : this.mDownloadCenter.m7895k()) {
                    if (downloadCenterTask.m7802p().mo1475b().equals(ttsSpeaker.mNickname)) {
                        WebLog.init().c(LogLevel.DISASTER, "task", "resume");
                        this.mDownloadCenter.m7879b(downloadCenterTask);
                        c0299i.m708a(getRetString(str, true));
                        return;
                    }
                }
                long j = ttsSpeaker.mResSize;
                Context context = getContext();
                String string = getString(C0258j.reading__tts_web_view__need_data);
                String string2 = getString(C0258j.reading__tts_web_view__data_usage);
                Object[] objArr = new Object[1];
                objArr[0] = j <= 0 ? "" : DkPublic.formatBytes(j);
                FileTransferPrompter.m9977a(context, j, string, String.format(string2, objArr), new ky(this, jSONObject, ttsSpeaker, c0299i, str));
            } else {
                this.mTtsManager.addSpeaker(ttsSpeaker);
                this.mTtsManager.setCurrentSpeaker(ttsSpeaker);
                onDone(jSONObject, true);
                c0299i.m708a(getRetString(str, true));
            }
        } catch (Throwable th) {
            c0299i.m708a(getRetString(str, false));
        }
    }

    private String pauseDownload(String str) {
        TtsSpeaker ttsSpeaker = new TtsSpeaker(str);
        for (DownloadCenterTask downloadCenterTask : this.mDownloadCenter.m7895k()) {
            if (downloadCenterTask.m7802p().mo1475b().equals(ttsSpeaker.mNickname)) {
                if (downloadCenterTask.m7788b() || downloadCenterTask.m7789c()) {
                    return getRetString(str, true);
                }
                if (downloadCenterTask.m7790d()) {
                    this.mDownloadCenter.m7885c(downloadCenterTask);
                    return getRetString(str, true);
                }
            }
        }
        Iterator it = this.mFutureDownloadSpeakers.iterator();
        while (it.hasNext()) {
            C1025l c1025l = (C1025l) it.next();
            if (c1025l.f5079a.equals(ttsSpeaker.mName)) {
                c1025l.f5084f = false;
                return getRetString(str, true);
            }
        }
        return getRetString(str, false);
    }

    private String resumeDownload(String str) {
        TtsSpeaker ttsSpeaker = new TtsSpeaker(str);
        for (DownloadCenterTask downloadCenterTask : this.mDownloadCenter.m7895k()) {
            if (downloadCenterTask.m7802p().mo1475b().equals(ttsSpeaker.mNickname)) {
                if (downloadCenterTask.m7788b() || downloadCenterTask.m7789c()) {
                    this.mDownloadCenter.m7879b(downloadCenterTask);
                    return getRetString(str, true);
                } else if (downloadCenterTask.m7790d()) {
                    return getRetString(str, true);
                }
            }
        }
        Iterator it = this.mFutureDownloadSpeakers.iterator();
        while (it.hasNext()) {
            C1025l c1025l = (C1025l) it.next();
            if (c1025l.f5079a.equals(ttsSpeaker.mName)) {
                c1025l.f5084f = true;
                if (this.mTtsManager.isBaseResourceDownloaded()) {
                    this.mDownloadCenter.m7865a(c1025l);
                    this.mFutureDownloadSpeakers.remove(c1025l);
                }
                return getRetString(str, true);
            }
        }
        return getRetString(str, false);
    }

    private String removeSpeaker(String str) {
        if (TextUtils.isEmpty(str)) {
            return getRetString(str, false);
        }
        return getRetString(str, this.mTtsManager.removeSelectedSpeaker(str));
    }

    private void close() {
        requestBack();
    }

    protected boolean onBack() {
        Collection l = this.mDownloadCenter.m7896l();
        if (l.size() <= 0) {
            return super.onBack();
        }
        this.mDownloadCenter.m7881b(l);
        ap apVar = new ap(getContext());
        apVar.setOkLabelResid(C0258j.general__shared__stop);
        apVar.setCancelLabel(C0258j.general__shared__continue);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(true);
        apVar.setPrompt(C0258j.reading__tts_web_view__download_prompt);
        apVar.open(new kz(this, l));
        return true;
    }

    private void reload() {
        this.mWebView.reload();
    }

    private String payTts(String str, String str2) {
        Object ttsUserId = this.mTtsManager.getTtsUserId();
        if (TextUtils.isEmpty(ttsUserId)) {
            C0709k.m3476a().m3495a(new la(this));
            return "";
        }
        pay(ttsUserId, str, str2);
        return "";
    }

    private void pay(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject(str3);
            String string = jSONObject.getString("packId");
            String string2 = jSONObject.getString("resId");
            String string3 = jSONObject.getString("price");
            final String[] strArr = new String[]{"", ""};
            final WebSession lbVar = new lb(this, C0643q.f2173a, strArr, str2, str3);
            ActivatedController c13516 = new StorePageController(getContext()) {
                protected ci newJavascriptImpl() {
                    return new lc(this);
                }
            };
            c13516.loadUrl(C0641o.m2934i().m2956a(str, string, string2, getDevice(), string3));
            ((ReaderFeature) AppContext.getAppContext(getContext()).queryFeature(ReaderFeature.class)).showPopup(c13516);
        } catch (Throwable th) {
            WebLog.init().c(LogLevel.ERROR, "tts_payment", "trans_info_decode_error");
        }
    }

    private void freetrial(String str) {
    }

    private String getRetString(String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (z) {
            try {
                jSONObject.put("code", 0);
            } catch (JSONException e) {
            }
        } else {
            jSONObject.put("code", 1);
        }
        jSONObject.put(KEY_SPEAKER, new JSONObject(str));
        return jSONObject.toString();
    }

    private void addDownloadTask(JSONObject jSONObject, TtsSpeaker ttsSpeaker, FlowChargingTransferChoice flowChargingTransferChoice) {
        try {
            C1025l c1025l = new C1025l();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pack_name", ttsSpeaker.mNickname);
            jSONObject2.put("pack_info", jSONObject);
            c1025l.f5079a = ttsSpeaker.mName;
            c1025l.f5083e = new ab(jSONObject2);
            c1025l.f5083e.f5036m = flowChargingTransferChoice;
            c1025l.f5080b = new String(Base64.decode(jSONObject.getString("resPath").getBytes(), 0));
            String ttsFileUri = this.mTtsManager.getTtsFileUri(ttsSpeaker);
            if (TextUtils.isEmpty(ttsFileUri) || !FileUtil.deleteFile(new File(ttsFileUri))) {
                onDone(jSONObject, false);
                return;
            }
            c1025l.f5081c = ttsFileUri + "/tts";
            if (this.mTtsManager.isBaseResourceDownloaded() || ttsSpeaker.mId.equals(String.valueOf(-1))) {
                this.mDownloadCenter.m7865a(c1025l);
            } else {
                this.mFutureDownloadSpeakers.add(c1025l);
            }
        } catch (Throwable th) {
            onDone(jSONObject, false);
            be.m10286a(getContext(), C0258j.bookshelf__general_shared__download_failed, 0);
        }
    }

    private void onProgress(JSONObject jSONObject, float f) {
        UThread.runOnThread(new le(this, f, jSONObject));
    }

    private void onDone(JSONObject jSONObject, boolean z) {
        UThread.runOnThread(new lf(this, z, jSONObject));
    }
}

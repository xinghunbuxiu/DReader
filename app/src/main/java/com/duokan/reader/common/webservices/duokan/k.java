package com.duokan.reader.common.webservices.duokan;

import android.os.Bundle;
import android.util.Base64;

import com.duokan.core.io.FileUtils;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.d;
import com.duokan.reader.common.webservices.duokan.a.a;
import com.duokan.reader.common.webservices.duokan.a.c;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.MiGuestAccount;
import com.duokan.reader.domain.account.bq;
import com.duokan.reader.domain.account.i;
import com.mipay.sdk.Mipay;
import com.xiaomi.passport.accountmanager.MiAccountManager;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class k extends d {
    private final MiAccountManager a;

    public k(WebSession webSession, MiAccountManager miAccountManager) {
        super(webSession);
        this.a = miAccountManager;
    }

    protected void a(a aVar, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder(str2);
        List<String> a = aVar.a(str);
        if (a != null) {
            for (String append : a) {
                stringBuilder.append(append);
            }
        }
        aVar.b(str, stringBuilder.toString());
    }

    protected String a(boolean z, String str) {
        if (str.startsWith("https://") || str.startsWith("http://")) {
            return str;
        }
        return (z ? "https://" : "http://") + str;
    }

    protected a a(boolean z, String str, String... strArr) {
        String a = a(z, str);
        List linkedList = new LinkedList();
        for (int i = 0; i < strArr.length; i += 2) {
            linkedList.add(new BasicNameValuePair(strArr[i], strArr[i + 1]));
        }
        return new c().b(a).a(HttpPost.METHOD_NAME).a(linkedList).a();
    }

    protected a b(boolean z, String str, String... strArr) {
        String a = a(z, str);
        int i = 0;
        while (i < strArr.length) {
            a = (a + (i == 0 ? "?" : "&")) + strArr[i] + "=" + strArr[i + 1];
            i += 2;
        }
        return new c().b(a).a(HttpGet.METHOD_NAME).a();
    }

    public b a(Map map) {
        List arrayList = new ArrayList();
        for (String f : map.keySet()) {
            arrayList.add(f(f).a);
        }
        Collections.sort(arrayList, new l(this));
        b bVar = new b();
        bVar.b = 0;
        bVar.a = arrayList;
        return bVar;
    }

    public b a() {
        b bVar = new b();
        try {
            bVar.a = a(a(b(false, "http://api.bbs.miui.com/app/user/getuser", new String[0]))).getString("name");
        } catch (Throwable th) {
            bVar.a = "";
        }
        return bVar;
    }

    public b e(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("nickname");
        arrayList.add(str);
        JSONObject a = a(a(a(false, "http://api.bbs.miui.com/app/user/setnickname", (String[]) arrayList.toArray(new String[0]))));
        b bVar = new b();
        bVar.b = a.getInt("status");
        bVar.a = str;
        bVar.c = a.getString("info");
        return bVar;
    }

    public b f(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tid");
        arrayList.add(str);
        JSONObject a = a(a(b(false, "http://api.bbs.miui.com/app/forum/thread", (String[]) arrayList.toArray(new String[0]))));
        b bVar = new b();
        DkFeedbackThreadInfo dkFeedbackThreadInfo = new DkFeedbackThreadInfo();
        bVar.b = a.optInt("error", 0);
        if (bVar.b == 0) {
            dkFeedbackThreadInfo.mSubject = a.getString("subject");
            dkFeedbackThreadInfo.mAuthorId = a.getString("authorid");
            dkFeedbackThreadInfo.mThreadId = a.getString("tid");
            dkFeedbackThreadInfo.mDateLine = a.getLong("dateline");
            dkFeedbackThreadInfo.mReplyCount = a.getInt("replies");
            dkFeedbackThreadInfo.mValid = true;
        } else {
            dkFeedbackThreadInfo.mThreadId = str;
            dkFeedbackThreadInfo.mValid = false;
        }
        bVar.a = dkFeedbackThreadInfo;
        return bVar;
    }

    public b a(String str, int i) {
        List arrayList = new ArrayList();
        JSONObject a = a(arrayList, str, i);
        while (a.getBoolean("more")) {
            a.put("more", a(arrayList, str, ((DkFeedbackReply) arrayList.get(arrayList.size() - 1)).mPosition).getBoolean("more"));
        }
        b bVar = new b();
        bVar.b = a.getInt("error");
        bVar.a = arrayList;
        bVar.c = a.optString("desc", "");
        return bVar;
    }

    private JSONObject a(List list, String str, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tid");
        arrayList.add(str);
        arrayList.add("lastposition");
        arrayList.add(String.valueOf(i));
        String b = b(a(b(false, "http://api.bbs.miui.com/app/forum/viewthread", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray(b);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                DkFeedbackReply dkFeedbackReply = new DkFeedbackReply();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                dkFeedbackReply.mPId = jSONObject2.getString("pid");
                dkFeedbackReply.mUserId = jSONObject2.getString("authorid");
                dkFeedbackReply.mMessage = a(jSONObject2);
                dkFeedbackReply.mPosition = Integer.parseInt(jSONObject2.getString("position"));
                dkFeedbackReply.mDateLine = Long.parseLong(jSONObject2.getString("dateline"));
                list.add(dkFeedbackReply);
            }
            jSONObject.put("error", 0);
            jSONObject.put("more", jSONArray.length() == 20);
            return jSONObject;
        } catch (Throwable th) {
            jSONObject = new JSONObject(b);
            jSONObject.put("more", false);
            return jSONObject;
        }
    }

    private String a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray(Mipay.KEY_MESSAGE);
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            String str = (String) jSONObject2.keys().next();
            if ("txt".equals(str)) {
                str = jSONObject2.getString(str);
                i = str.indexOf("附件: <setDrawable");
                if (i != -1) {
                    str = str.substring(0, i);
                }
                return str.replaceAll("\\n+?", "").replaceAll("\\[.+?\\]", "").replaceAll("<.+?>", "");
            }
        }
        return "";
    }

    public b a(String str, String str2, String str3, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("fid");
        arrayList.add("508");
        arrayList.add("typeid");
        arrayList.add(str);
        arrayList.add("subject");
        arrayList.add(str2);
        arrayList.add(Mipay.KEY_MESSAGE);
        arrayList.add(str3);
        if (z && !str.equals("3707")) {
            arrayList.add("attachnew");
            arrayList.add("[" + b() + "]");
        }
        arrayList.add("fromClient");
        arrayList.add(ReaderEnv.get().getAppName());
        JSONObject a = a(a(a(false, "http://api.bbs.miui.com/app/forum/newthread", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt("error");
        if (bVar.b == 0) {
            bVar.a = a.getString("tid");
        }
        bVar.c = a.getString("desc");
        return bVar;
    }

    private String b() {
        Throwable th;
        int i = 0;
        String str = "";
        ArrayList arrayList = new ArrayList();
        arrayList.add("fid");
        arrayList.add("508");
        List linkedList = new LinkedList();
        for (int i2 = 0; i2 < arrayList.size(); i2 += 2) {
            linkedList.add(new BasicNameValuePair((String) arrayList.get(i2), (String) arrayList.get(i2 + 1)));
        }
        String valueOf = String.valueOf(Base64.encode(String.valueOf(Math.random()).getBytes(), 0));
        File b = FileUtils.getRealFile(ReaderEnv.get().getPrivateCacheDirectory());
        File b2 = FileUtils.getRealFile(ReaderEnv.get().getPrivateCacheDirectory());
        Closeable fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(b);
            try {
                fileOutputStream.write(new StringBuffer().append("--").append(valueOf).append("\r\n").append("Content-Disposition: form-data; name=\"Filedata\"; filename=\"diagnostic.zip\"\r\n").append("Content-Type: file\r\n\r\n").toString().getBytes());
                if (DkPublic.zipFile(DkApp.get().getDiagnosticDirectory(), b2)) {
                    i = 1;
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(b2));
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.write(("\r\n--" + valueOf + "--\r\n").getBytes());
                }
                FileUtil1.a(fileOutputStream);
                if (i != 0) {
                    valueOf = a(a(new c().b("http://api.bbs.miui.com/app/upload/forumupload").a(HttpPost.METHOD_NAME).a(linkedList).a(b).c(valueOf).a()), HTTP.UTF_8).getString("aid");
                } else {
                    valueOf = str;
                }
                FileUtils.deleteFile(b);
                FileUtils.deleteFile(b2);
                return valueOf;
            } catch (Throwable th2) {
                th = th2;
                FileUtil1.a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            FileUtil1.a(fileOutputStream);
            throw th;
        }
    }

    public b a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tid");
        arrayList.add(str);
        arrayList.add(Mipay.KEY_MESSAGE);
        arrayList.add(str2);
        arrayList.add("replyTo");
        arrayList.add(str3);
        arrayList.add("fromClient");
        arrayList.add(ReaderEnv.get().getAppName());
        JSONObject a = a(a(a(false, "http://api.bbs.miui.com/app/forum/reply", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt("error");
        bVar.c = a.getString("desc");
        return bVar;
    }

    public com.duokan.reader.common.webservices.duokan.a.d a(a aVar) {
        StringBuilder stringBuilder = new StringBuilder();
        if (i.f().a().equals(AccountType.XIAOMI_GUEST)) {
            MiGuestAccount miGuestAccount = (MiGuestAccount) i.f().c();
            stringBuilder.append(String.format("cUserId=%s;serviceToken=%s;", new Object[]{((bq) miGuestAccount.f()).b.g, miGuestAccount.f}));
        } else if (i.f().a().equals(AccountType.XIAO_MI)) {
            stringBuilder.append(String.format("cUserId=%s;serviceToken=%s;", new Object[]{c(), d()}));
        }
        a(aVar, SM.COOKIE, stringBuilder.toString());
        return super.a(aVar);
    }

    private String c() {
        return this.a.getUserData(this.a.getXiaomiAccount(), "encrypted_user_id");
    }

    private String d() {
        try {
            Bundle bundle = (Bundle) this.a.getAuthToken(this.a.getXiaomiAccount(), "miuibbs", null, false, null, null).getResult();
            if (bundle != null) {
                return bundle.getString("authtoken");
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}

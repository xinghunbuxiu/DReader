package com.duokan.reader.common.webservices.duokan;

import android.os.Bundle;
import android.util.Base64;
import com.duokan.core.io.FileUtil;
import com.duokan.core.io.IOUtils;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.C0237c;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.common.webservices.duokan.p040a.C0626c;
import com.duokan.reader.common.webservices.duokan.p040a.C0627d;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiGuestAccount;
import com.duokan.reader.domain.account.bl;
import com.mipay.sdk.Mipay;
import com.xiaomi.passport.accountmanager.MiAccountManager;
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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.webservices.duokan.k */
public class C0637k extends C0237c {
    /* renamed from: a */
    private final MiAccountManager f2142a;

    public C0637k(WebSession webSession, MiAccountManager miAccountManager) {
        super(webSession);
        this.f2142a = miAccountManager;
    }

    /* renamed from: a */
    protected void m2890a(C0624a c0624a, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder(str2);
        List<String> a = c0624a.m2834a(str);
        if (a != null) {
            for (String append : a) {
                stringBuilder.append(append);
            }
        }
        c0624a.m2837b(str, stringBuilder.toString());
    }

    /* renamed from: a */
    protected String m2889a(boolean z, String str) {
        if (str.startsWith("https://") || str.startsWith("http://")) {
            return str;
        }
        return (z ? "https://" : "http://") + str;
    }

    /* renamed from: a */
    protected C0624a m2887a(boolean z, String str, String... strArr) {
        String a = m2889a(z, str);
        List linkedList = new LinkedList();
        for (int i = 0; i < strArr.length; i += 2) {
            linkedList.add(new BasicNameValuePair(strArr[i], strArr[i + 1]));
        }
        return new C0626c().m2856b(a).m2853a(HttpPost.METHOD_NAME).m2854a(linkedList).m2851a();
    }

    /* renamed from: b */
    protected C0624a m2891b(boolean z, String str, String... strArr) {
        String a = m2889a(z, str);
        int i = 0;
        while (i < strArr.length) {
            a = (a + (i == 0 ? "?" : "&")) + strArr[i] + "=" + strArr[i + 1];
            i += 2;
        }
        return new C0626c().m2856b(a).m2853a(HttpGet.METHOD_NAME).m2851a();
    }

    /* renamed from: a */
    public C0621a<List<DkFeedbackThreadInfo>> m2886a(Map<String, Integer> map) {
        List arrayList = new ArrayList();
        for (String f : map.keySet()) {
            arrayList.add(m2893f(f).f2058a);
        }
        Collections.sort(arrayList, new C0638l(this));
        C0621a<List<DkFeedbackThreadInfo>> c0621a = new C0621a();
        c0621a.b = 0;
        c0621a.f2058a = arrayList;
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<String> m2882a() {
        C0621a<String> c0621a = new C0621a();
        try {
            c0621a.f2058a = m547a(mo376a(m2891b(false, "http://api.bbs.miui.com/app/user/getuser", new String[0]))).getString("name");
        } catch (Throwable th) {
            c0621a.f2058a = "";
        }
        return c0621a;
    }

    /* renamed from: e */
    public C0621a<String> m2892e(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("nickname");
        arrayList.add(str);
        JSONObject a = m547a(mo376a(m2887a(false, "http://api.bbs.miui.com/app/user/setnickname", (String[]) arrayList.toArray(new String[0]))));
        C0621a<String> c0621a = new C0621a();
        c0621a.b = a.getInt("status");
        c0621a.f2058a = str;
        c0621a.c = a.getString("info");
        return c0621a;
    }

    /* renamed from: f */
    public C0621a<DkFeedbackThreadInfo> m2893f(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tid");
        arrayList.add(str);
        JSONObject a = m547a(mo376a(m2891b(false, "http://api.bbs.miui.com/app/forum/thread", (String[]) arrayList.toArray(new String[0]))));
        C0621a<DkFeedbackThreadInfo> c0621a = new C0621a();
        DkFeedbackThreadInfo dkFeedbackThreadInfo = new DkFeedbackThreadInfo();
        c0621a.b = a.optInt("error", 0);
        if (c0621a.b == 0) {
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
        c0621a.f2058a = dkFeedbackThreadInfo;
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<List<DkFeedbackReply>> m2883a(String str, int i) {
        List arrayList = new ArrayList();
        JSONObject a = m2878a(arrayList, str, i);
        while (a.getBoolean("more")) {
            a.put("more", m2878a(arrayList, str, ((DkFeedbackReply) arrayList.get(arrayList.size() - 1)).mPosition).getBoolean("more"));
        }
        C0621a<List<DkFeedbackReply>> c0621a = new C0621a();
        c0621a.b = a.getInt("error");
        c0621a.f2058a = arrayList;
        c0621a.c = a.optString("desc", "");
        return c0621a;
    }

    /* renamed from: a */
    private JSONObject m2878a(List<DkFeedbackReply> list, String str, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tid");
        arrayList.add(str);
        arrayList.add("lastposition");
        arrayList.add(String.valueOf(i));
        String b = m550b(mo376a(m2891b(false, "http://api.bbs.miui.com/app/forum/viewthread", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray(b);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                DkFeedbackReply dkFeedbackReply = new DkFeedbackReply();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                dkFeedbackReply.mPId = jSONObject2.getString("pid");
                dkFeedbackReply.mUserId = jSONObject2.getString("authorid");
                dkFeedbackReply.mMessage = m2877a(jSONObject2);
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

    /* renamed from: a */
    private String m2877a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray(Mipay.KEY_MESSAGE);
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            String str = (String) jSONObject2.keys().next();
            if ("txt".equals(str)) {
                str = jSONObject2.getString(str);
                i = str.indexOf("附件: <a");
                if (i != -1) {
                    str = str.substring(0, i);
                }
                return str.replaceAll("\\n+?", "").replaceAll("\\[.+?\\]", "").replaceAll("<.+?>", "");
            }
        }
        return "";
    }

    /* renamed from: a */
    public C0621a<String> m2885a(String str, String str2, String str3, boolean z) {
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
            arrayList.add("[" + m2879b() + "]");
        }
        arrayList.add("fromClient");
        arrayList.add(ReaderEnv.get().getAppName());
        JSONObject a = m548a(mo376a(m2887a(false, "http://api.bbs.miui.com/app/forum/newthread", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        C0621a<String> c0621a = new C0621a();
        c0621a.b = a.getInt("error");
        if (c0621a.b == 0) {
            c0621a.f2058a = a.getString("tid");
        }
        c0621a.c = a.getString("desc");
        return c0621a;
    }

    /* renamed from: b */
    private String m2879b() {
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
        File d = FileUtil.getTempFile(ReaderEnv.get().getPrivateCacheDirectory());
        File d2 = FileUtil.getTempFile(ReaderEnv.get().getPrivateCacheDirectory());
        Closeable fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(d);
            try {
                fileOutputStream.write(new StringBuffer().append("--").append(valueOf).append("\r\n").append("Content-Disposition: form-data; name=\"Filedata\"; filename=\"diagnostic.zip\"\r\n").append("Content-Type: file\r\n\r\n").toString().getBytes());
                if (DkPublic.zipFile(DkApp.get().getDiagnosticDirectory(), d2)) {
                    i = 1;
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(d2));
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
                IOUtils.close(fileOutputStream);
                if (i != 0) {
                    valueOf = m548a(mo376a(new C0626c().m2856b("http://api.bbs.miui.com/app/upload/forumupload").m2853a(HttpPost.METHOD_NAME).m2854a(linkedList).m2852a(d).m2857c(valueOf).m2851a()), HTTP.UTF_8).getString("aid");
                } else {
                    valueOf = str;
                }
                FileUtil.deleteFile(d);
                FileUtil.deleteFile(d2);
                return valueOf;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.close(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            IOUtils.close(fileOutputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public C0621a<Void> m2884a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tid");
        arrayList.add(str);
        arrayList.add(Mipay.KEY_MESSAGE);
        arrayList.add(str2);
        arrayList.add("replyTo");
        arrayList.add(str3);
        arrayList.add("fromClient");
        arrayList.add(ReaderEnv.get().getAppName());
        JSONObject a = m548a(mo376a(m2887a(false, "http://api.bbs.miui.com/app/forum/reply", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        C0621a<Void> c0621a = new C0621a();
        c0621a.b = a.getInt("error");
        c0621a.c = a.getString("desc");
        return c0621a;
    }

    /* renamed from: a */
    public C0627d mo376a(C0624a c0624a) {
        StringBuilder stringBuilder = new StringBuilder();
        if (C0709k.m3476a().m3501b().equals(AccountType.XIAOMI_GUEST)) {
            MiGuestAccount miGuestAccount = (MiGuestAccount) C0709k.m3476a().m3508d();
            stringBuilder.append(String.format("cUserId=%s;serviceToken=%s;", new Object[]{((bl) miGuestAccount.mo836f()).f2425b.f2442d, miGuestAccount.f2259f}));
        } else if (C0709k.m3476a().m3501b().equals(AccountType.XIAO_MI)) {
            stringBuilder.append(String.format("cUserId=%s;serviceToken=%s;", new Object[]{m2880c(), m2881d()}));
        }
        m2890a(c0624a, SM.COOKIE, stringBuilder.toString());
        return super.mo376a(c0624a);
    }

    /* renamed from: c */
    private String m2880c() {
        return this.f2142a.getUserData(this.f2142a.getXiaomiAccount(), "encrypted_user_id");
    }

    /* renamed from: d */
    private String m2881d() {
        try {
            Bundle bundle = (Bundle) this.f2142a.getAuthToken(this.f2142a.getXiaomiAccount(), "miuibbs", null, false, null, null).getResult();
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

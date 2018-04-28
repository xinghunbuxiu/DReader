package com.duokan.reader.common.webservices.duokan;

import android.net.Uri;
import android.text.TextUtils;
import com.duokan.core.sys.C0373z;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.C0237c;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.common.webservices.duokan.p040a.C0626c;
import com.duokan.reader.common.webservices.duokan.p040a.C0627d;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.account.bd;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;

public class ac extends C0237c {
    /* renamed from: e */
    protected C0672a f378e;
    /* renamed from: f */
    protected al f379f;

    public ac(WebSession webSession, C0672a c0672a) {
        super(webSession);
        this.f378e = c0672a;
    }

    public ac(WebSession webSession, al alVar) {
        super(webSession);
        this.f379f = alVar;
    }

    /* renamed from: k */
    protected String m565k(String str) {
        return new C0650x(str).m3046a();
    }

    /* renamed from: a */
    protected void m559a(C0624a c0624a, String str) {
        if (!TextUtils.isEmpty(str)) {
            m560a(c0624a, SM.COOKIE, String.format("track=%s;", new Object[]{Uri.encode(str)}));
        }
    }

    /* renamed from: b */
    protected void mo1566b(C0624a c0624a) {
        if (this.f378e != null) {
            m560a(c0624a, SM.COOKIE, m557a(this.f378e.mo837g()));
        } else if (this.f379f != null) {
            m560a(c0624a, SM.COOKIE, m557a(this.f379f.f2365f));
        }
    }

    /* renamed from: a */
    protected String m557a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : map.keySet()) {
            stringBuilder.append(String.format("%s=%s;", new Object[]{str, map.get(str)}));
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    protected void m560a(C0624a c0624a, String str, String str2) {
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
    protected String m558a(boolean z, String str) {
        if (str.startsWith("https://") || str.startsWith("http://")) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = (z && C0641o.m2934i().m2984k()) ? "https://" : "http://";
        return stringBuilder.append(str2).append(str).toString();
    }

    /* renamed from: a */
    protected C0624a m555a(boolean z, String str, String... strArr) {
        int i = 0;
        String a = m558a(z, str);
        List linkedList = new LinkedList();
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            linkedList.add(new BasicNameValuePair(strArr[i2], strArr[i2 + 1]));
        }
        if (z) {
            String[] genCsrfCode = DkPublic.genCsrfCode();
            while (i < genCsrfCode.length) {
                linkedList.add(new BasicNameValuePair(genCsrfCode[i], genCsrfCode[i + 1]));
                i += 2;
            }
        }
        C0624a a2 = new C0626c().m2856b(a).m2853a(HttpPost.METHOD_NAME).m2854a(linkedList).m2851a();
        if (z) {
            mo1566b(a2);
        }
        return a2;
    }

    /* renamed from: b */
    protected C0624a m562b(boolean z, String str, String... strArr) {
        String a = m558a(z, str);
        int i = 0;
        while (i < strArr.length) {
            a = (a + (i == 0 ? "?" : "&")) + strArr[i] + "=" + strArr[i + 1];
            i += 2;
        }
        C0624a a2 = new C0626c().m2856b(a).m2853a(HttpGet.METHOD_NAME).m2851a();
        if (z) {
            mo1566b(a2);
        }
        return a2;
    }

    /* renamed from: a */
    public C0627d mo376a(C0624a c0624a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("device_id=%s;app_id=%s;build=%s;channel=%s;user_type=%d;", new Object[]{ReaderEnv.get().getDeviceId(), ReaderEnv.get().getAppId(), Integer.valueOf(ReaderEnv.get().getVersionCode()), ReaderEnv.get().getDistChannel(), Integer.valueOf(PersonalPrefs.m5175a().m5210b())}));
        if (!TextUtils.isEmpty(C0709k.m3476a().m3514i())) {
            stringBuilder.append(String.format("device_hash=%s;", new Object[]{C0709k.m3476a().m3514i()}));
        }
        Iterable j = C0709k.m3476a().m3515j();
        if (j != null && j.size() > 0) {
            stringBuilder.append(String.format("device_hash_set=%s;", new Object[]{TextUtils.join(",", j)}));
        }
        m560a(c0624a, SM.COOKIE, stringBuilder.toString());
        if (ReaderEnv.get().getBuildName().equals("Reader")) {
            m560a(c0624a, SM.COOKIE, "_n=1;");
        }
        if (C0373z.m1052a()) {
            m560a(c0624a, SM.COOKIE, "_m=1;");
        }
        c0624a.m2835a("Accept-Encoding", "gzip,deflate");
        return super.mo376a(c0624a);
    }

    /* renamed from: e */
    protected boolean m564e() {
        return ((this.f378e == null || TextUtils.isEmpty(this.f378e.mo833c())) && (this.f379f == null || TextUtils.isEmpty(this.f379f.f2362c))) ? false : true;
    }

    /* renamed from: a */
    protected void m561a(User user, boolean z) {
        if (m564e() && !this.f378e.mo839i()) {
            Object b = this.f378e != null ? this.f378e.mo832b() : this.f379f.f2360a;
            if (TextUtils.equals(b, user.mUserId) || z) {
                user.mUserId = b;
                String c = this.f378e != null ? this.f378e.mo833c() : this.f379f.f2362c;
                String a = this.f378e != null ? this.f378e.mo836f().mo871a() : this.f379f.f2363d;
                if (TextUtils.isEmpty(a) || c.equals(a)) {
                    user.mNickName = c;
                } else {
                    if (this.f378e.mo835e().equals(AccountType.ANONYMOUS)) {
                        a = "游客" + a;
                    }
                    user.mNickName = a;
                }
                if (this.f378e instanceof MiAccount) {
                    user.mIconUrl = ((bd) this.f378e.mo836f()).f2405e.f5458a.mIconUrl;
                }
            }
        }
    }
}

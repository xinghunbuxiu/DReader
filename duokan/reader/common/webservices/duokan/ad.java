package com.duokan.reader.common.webservices.duokan;

import android.net.Uri;
import android.text.TextUtils;

import com.duokan.core.sys.z;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.d;
import com.duokan.reader.common.webservices.duokan.a.c;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.bh;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.PersonalPrefs;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ad extends d {
    protected a e;
    protected ab f;

    public ad(WebSession webSession, a aVar) {
        super(webSession);
        this.e = aVar;
    }

    public ad(WebSession webSession, ab abVar) {
        super(webSession);
        this.f = abVar;
    }

    protected String j(String str) {
        return new y(str).a();
    }

    protected void a(com.duokan.reader.common.webservices.duokan.a.a aVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            a(aVar, SM.COOKIE, String.format("track=%s;", new Object[]{Uri.encode(str)}));
        }
    }

    protected void b(com.duokan.reader.common.webservices.duokan.a.a aVar) {
        if (this.e != null) {
            a(aVar, SM.COOKIE, a(this.e.g()));
        } else if (this.f != null) {
            a(aVar, SM.COOKIE, a(this.f.f));
        }
    }

    private String a(Map map) {
        if (map == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : map.keySet()) {
            stringBuilder.append(String.format("%s=%s;", new Object[]{str, map.get(str)}));
        }
        return stringBuilder.toString();
    }

    protected void a(com.duokan.reader.common.webservices.duokan.a.a aVar, String str, String str2) {
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
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = (z && p.i().k()) ? "https://" : "http://";
        return stringBuilder.append(str2).append(str).toString();
    }

    protected com.duokan.reader.common.webservices.duokan.a.a a(boolean z, String str, String... strArr) {
        int i = 0;
        String a = a(z, str);
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
        com.duokan.reader.common.webservices.duokan.a.a a2 = new c().b(a).a(HttpPost.METHOD_NAME).a(linkedList).a();
        if (z) {
            b(a2);
        }
        return a2;
    }

    protected com.duokan.reader.common.webservices.duokan.a.a b(boolean z, String str, String... strArr) {
        String a = a(z, str);
        int i = 0;
        while (i < strArr.length) {
            a = (a + (i == 0 ? "?" : "&")) + strArr[i] + "=" + strArr[i + 1];
            i += 2;
        }
        com.duokan.reader.common.webservices.duokan.a.a a2 = new c().b(a).a(HttpGet.METHOD_NAME).a();
        if (z) {
            b(a2);
        }
        return a2;
    }

    public com.duokan.reader.common.webservices.duokan.a.d a(com.duokan.reader.common.webservices.duokan.a.a aVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("device_id=%s;app_id=%s;build=%s;channel=%s;user_type=%getTriangleEdge;", new Object[]{ReaderEnv.get().getDeviceId(), ReaderEnv.get().getAppId(), Integer.valueOf(ReaderEnv.get().getVersionCode()), ReaderEnv.get().getDistChannel(), Integer.valueOf(PersonalPrefs.a().b())}));
        if (!TextUtils.isEmpty(i.f().i())) {
            stringBuilder.append(String.format("device_hash=%s;", new Object[]{i.f().i()}));
        }
        Iterable j = i.f().j();
        if (j != null && j.size() > 0) {
            stringBuilder.append(String.format("device_hash_set=%s;", new Object[]{TextUtils.join(",", j)}));
        }
        a(aVar, SM.COOKIE, stringBuilder.toString());
        if (ReaderEnv.get().getBuildName().equals("Reader")) {
            a(aVar, SM.COOKIE, "_n=1;");
        }
        if (z.a()) {
            a(aVar, SM.COOKIE, "_m=1;");
        }
        aVar.a("Accept-Encoding", "gzip,deflate");
        return super.a(aVar);
    }

    protected boolean e() {
        return ((this.e == null || TextUtils.isEmpty(this.e.c())) && (this.f == null || TextUtils.isEmpty(this.f.c))) ? false : true;
    }

    protected void a(User user, boolean z) {
        if (e() && !this.e.i()) {
            Object b = this.e != null ? this.e.b() : this.f.a;
            if (TextUtils.equals(b, user.mUserId) || z) {
                user.mUserId = b;
                String c = this.e != null ? this.e.c() : this.f.c;
                String a = this.e != null ? this.e.f().a() : this.f.d;
                if (TextUtils.isEmpty(a) || c.equals(a)) {
                    user.mNickName = c;
                } else {
                    if (this.e.e().equals(AccountType.ANONYMOUS)) {
                        a = "游客" + a;
                    }
                    user.mNickName = a;
                }
                if (this.e instanceof MiAccount) {
                    user.mIconUrl = ((bh) this.e.f()).e.a.mIconUrl;
                }
            }
        }
    }
}

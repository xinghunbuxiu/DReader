package com.duokan.reader.domain.account.p042a;

import com.duokan.reader.DkApp;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.C0237c;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.common.webservices.duokan.p040a.C0626c;
import com.duokan.reader.domain.account.C0709k;
import com.mipay.sdk.Mipay;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.account.a.n */
class C0687n extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0686m f2315a;
    /* renamed from: b */
    private JSONObject f2316b;

    C0687n(C0686m c0686m, C0657i c0657i) {
        this.f2315a = c0686m;
        super(c0657i);
    }

    protected void onSessionTry() {
        List linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("package", DkApp.get().getPackageName()));
        linkedList.add(new BasicNameValuePair(Mipay.KEY_CODE, this.f2315a.f2314c));
        String[] genCsrfCode = DkPublic.genCsrfCode();
        for (int i = 0; i < genCsrfCode.length; i += 2) {
            linkedList.add(new BasicNameValuePair(genCsrfCode[i], genCsrfCode[i + 1]));
        }
        C0624a a = new C0626c().m2853a(HttpPost.METHOD_NAME).m2856b(C0641o.m2934i().m2947K()).m2854a(linkedList).m2851a();
        a.m2835a(SM.COOKIE, "device_id=" + ReaderEnv.get().getDeviceId() + ";device_hash=" + C0709k.m3476a().m3514i());
        this.f2316b = new C0237c(this).m547a(execute(a));
    }

    protected void onSessionSucceeded() {
        if (this.f2315a.f2312a.m3230a(this.f2316b)) {
            this.f2315a.f2313b.mo855a(this.f2315a.f2313b.mo858c());
        } else {
            this.f2315a.f2313b.mo855a(this.f2315a.f2313b.mo861f());
        }
    }

    protected void onSessionFailed() {
        this.f2315a.f2313b.mo855a(this.f2315a.f2313b.mo861f());
    }
}

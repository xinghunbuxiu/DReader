package com.duokan.reader.domain.account;

import com.duokan.reader.DkApp;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.d;
import com.duokan.reader.common.webservices.duokan.a.a;
import com.duokan.reader.common.webservices.duokan.a.c;
import com.duokan.reader.common.webservices.duokan.p;
import com.mipay.sdk.Mipay;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

class bl extends WebSession {
    final /* synthetic */ String a;
    final /* synthetic */ b b;
    final /* synthetic */ MiGuestAccount c;
    private JSONObject d;

    bl(MiGuestAccount miGuestAccount, String str, b bVar) {
        this.c = miGuestAccount;
        this.a = str;
        this.b = bVar;
    }

    protected void onSessionTry() {
        List linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("package", DkApp.get().getPackageName()));
        linkedList.add(new BasicNameValuePair(Mipay.KEY_CODE, this.a));
        String[] genCsrfCode = DkPublic.genCsrfCode();
        for (int i = 0; i < genCsrfCode.length; i += 2) {
            linkedList.add(new BasicNameValuePair(genCsrfCode[i], genCsrfCode[i + 1]));
        }
        a a = new c().a(HttpPost.METHOD_NAME).b(p.i().M()).a(linkedList).a();
        a.a(SM.COOKIE, "device_id=" + ReaderEnv.get().getDeviceId() + ";device_hash=" + i.f().i());
        this.d = new d(this).a(execute(a));
    }

    protected void onSessionSucceeded() {
        if (this.c.a(this.d)) {
            MiGuestAccount.k.a(this.c, false, new bm(this));
        } else {
            this.b.a(this.c, "");
        }
    }

    protected void onSessionFailed() {
        this.b.a(this.c, "");
    }
}

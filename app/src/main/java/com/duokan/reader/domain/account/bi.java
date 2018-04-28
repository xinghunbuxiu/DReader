package com.duokan.reader.domain.account;

import com.duokan.reader.common.webservices.C0237c;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p040a.C0627d;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import org.json.JSONObject;

class bi extends WebSession {
    /* renamed from: a */
    final /* synthetic */ MiGuestAccount f2422a;

    bi(MiGuestAccount miGuestAccount) {
        this.f2422a = miGuestAccount;
    }

    protected void onSessionTry() {
        C0627d execute = execute(this.f2422a.m3225d("micloud"));
        JSONObject a = new C0237c(this).m547a(execute);
        this.f2422a.f2258e = ExtendedAuthToken.build(a.getJSONObject("data").optString("micloud_serviceToken"), new JSONObject((String) execute.mo815a("extension-pragma").get(0)).getString("ssecurity"));
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}

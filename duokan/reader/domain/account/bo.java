package com.duokan.reader.domain.account;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.a.d;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;

import org.json.JSONObject;

class bo extends WebSession {
    final /* synthetic */ MiGuestAccount a;

    bo(MiGuestAccount miGuestAccount) {
        this.a = miGuestAccount;
    }

    protected void onSessionTry() {
        d execute = execute(this.a.d("micloud"));
        JSONObject a = new com.duokan.reader.common.webservices.d(this).a(execute);
        this.a.e = ExtendedAuthToken.build(a.getJSONObject("data").optString("micloud_serviceToken"), new JSONObject((String) execute.a("extension-pragma").get(0)).getString("ssecurity"));
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}

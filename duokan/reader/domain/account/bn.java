package com.duokan.reader.domain.account;

import android.text.TextUtils;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.d;
import com.duokan.reader.common.webservices.duokan.a.c;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.SM;

class bn extends WebSession {
    final /* synthetic */ MiGuestAccount a;

    bn(MiGuestAccount miGuestAccount) {
        this.a = miGuestAccount;
    }

    protected void onSessionTry() {
        String optString = new d(this).a(execute(this.a.d("miuibbs"))).getJSONObject("data").optString("callback");
        if (!TextUtils.isEmpty(optString)) {
            for (String optString2 : execute(new c().b(optString2).a(HttpGet.METHOD_NAME).a()).a(SM.SET_COOKIE)) {
                if (optString2.contains("serviceToken=")) {
                    this.a.f = optString2.substring(optString2.indexOf("serviceToken=") + "serviceToken=".length(), optString2.indexOf(";"));
                }
            }
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}

package com.duokan.reader.domain.account;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.C0237c;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p040a.C0626c;
import com.iflytek.speech.VoiceWakeuperAidl;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.SM;

class bh extends WebSession {
    /* renamed from: a */
    final /* synthetic */ MiGuestAccount f2421a;

    bh(MiGuestAccount miGuestAccount) {
        this.f2421a = miGuestAccount;
    }

    protected void onSessionTry() {
        String optString = new C0237c(this).m547a(execute(this.f2421a.m3225d("miuibbs"))).getJSONObject("data").optString("callback");
        if (!TextUtils.isEmpty(optString)) {
            for (String optString2 : execute(new C0626c().m2856b(optString2).m2853a(HttpGet.METHOD_NAME).m2851a()).mo815a(SM.SET_COOKIE)) {
                if (optString2.contains("serviceToken=")) {
                    this.f2421a.f2259f = optString2.substring(optString2.indexOf("serviceToken=") + "serviceToken=".length(), optString2.indexOf(VoiceWakeuperAidl.PARAMS_SEPARATE));
                }
            }
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}

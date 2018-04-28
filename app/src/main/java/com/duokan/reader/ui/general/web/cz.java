package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.as;
import com.mipay.sdk.Mipay;
import org.json.JSONObject;

class cz implements as {
    /* renamed from: a */
    final /* synthetic */ String f7711a;
    /* renamed from: b */
    final /* synthetic */ ci f7712b;

    cz(ci ciVar, String str) {
        this.f7712b = ciVar;
        this.f7711a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7711a);
        String optString = jSONObject.optString("level");
        String optString2 = jSONObject.optString(Mipay.KEY_MESSAGE);
        if (!TextUtils.isEmpty(optString2)) {
            try {
                C0328a.m757c().m752c(LogLevel.valueOf(optString.toUpperCase()), "webview", optString2);
            } catch (Throwable th) {
                C0328a.m757c().m752c(LogLevel.INFO, "webview", optString2);
            }
        }
    }
}

package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.sys.as;
import com.duokan.reader.common.C0611i;
import com.duokan.reader.domain.payment.C1090d;
import org.json.JSONObject;

class db implements as {
    /* renamed from: a */
    final /* synthetic */ String f7715a;
    /* renamed from: b */
    final /* synthetic */ ci f7716b;

    db(ci ciVar, String str) {
        this.f7716b = ciVar;
        this.f7715a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7715a);
        String string = jSONObject.getString("msgid");
        JSONObject jSONObject2 = jSONObject.getJSONObject("params");
        Object string2 = jSONObject2.getString("orderInfo");
        String optString = jSONObject2.optString("payment_method");
        String b = C0611i.m2793b(jSONObject2, "url");
        jSONObject2 = jSONObject2.optJSONObject("continue");
        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(optString)) {
                optString = "MIPAY";
            }
            C1090d a = C1090d.m8364a(string2, optString);
            if (a != null) {
                this.f7716b.f7581b.js_pay(string, b, a, jSONObject2);
            } else {
                this.f7716b.f7581b.web_notifyWeb(string, 1, new Object[0]);
            }
        }
    }
}

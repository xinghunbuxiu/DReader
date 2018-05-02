package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.sys.as;
import com.duokan.reader.common.i;
import com.duokan.reader.domain.payment.d;

import org.json.JSONObject;

class cu implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    cu(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
        String string = jSONObject.getString("msgid");
        JSONObject jSONObject2 = jSONObject.getJSONObject("params");
        Object string2 = jSONObject2.getString("orderInfo");
        String optString = jSONObject2.optString("payment_method");
        String b = i.b(jSONObject2, "url");
        jSONObject2 = jSONObject2.optJSONObject("continue");
        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(optString)) {
                optString = "MIPAY";
            }
            d a = d.a(string2, optString);
            if (a != null) {
                this.b.pageController.js_pay(string, b, a, jSONObject2);
            } else {
                this.b.pageController.web_notifyWeb(string, 1, new Object[0]);
            }
        }
    }
}

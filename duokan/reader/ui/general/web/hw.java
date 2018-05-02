package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.sys.as;

import org.json.JSONObject;

class hw implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    hw(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString("title", "");
        String optString3 = jSONObject.optString("cover", "");
        String optString4 = jSONObject.optString("summary", "");
        Object optString5 = jSONObject.optString("bookUuids", "");
        String[] split = TextUtils.isEmpty(optString5) ? new String[0] : optString5.split(",");
        Object optString6 = jSONObject.optString("trace_id", "");
        this.b.a(new hx(this, optString, optString2, optString4, optString3, split, TextUtils.isEmpty(optString6) ? new String[0] : optString6.split(",")));
    }
}

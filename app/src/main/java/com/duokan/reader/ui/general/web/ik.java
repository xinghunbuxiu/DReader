package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import org.json.JSONObject;

class ik implements as {
    /* renamed from: a */
    final /* synthetic */ String f7995a;
    /* renamed from: b */
    final /* synthetic */ ci f7996b;

    ik(ci ciVar, String str) {
        this.f7996b = ciVar;
        this.f7995a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7995a);
        String optString = jSONObject.optString("msgid");
        jSONObject = jSONObject.optJSONObject("params");
        this.f7996b.m11016a(new il(this, optString, jSONObject.optString("platform", ""), jSONObject.optString("image_url", ""), jSONObject.optString("image_data", ""), jSONObject.optString("summary", "")));
    }
}

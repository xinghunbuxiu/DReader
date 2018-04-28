package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import org.json.JSONObject;

class hn implements as {
    /* renamed from: a */
    final /* synthetic */ String f7936a;
    /* renamed from: b */
    final /* synthetic */ ci f7937b;

    hn(ci ciVar, String str) {
        this.f7937b = ciVar;
        this.f7936a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7936a);
        String string = jSONObject.getString("msgid");
        JSONObject jSONObject2 = jSONObject.getJSONObject("params");
        String string2 = jSONObject2.getString("bookUuid");
        this.f7937b.m11016a(new ho(this, jSONObject2, string, jSONObject2.getString("state").toUpperCase(), string2, jSONObject2.optString("trace_id")));
    }
}

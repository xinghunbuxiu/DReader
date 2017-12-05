package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

import org.json.JSONObject;

class hf implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    hf(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
        String string = jSONObject.getString("msgid");
        JSONObject jSONObject2 = jSONObject.getJSONObject("params");
        String string2 = jSONObject2.getString("bookUuid");
        this.b.a(new hg(this, jSONObject2, string, jSONObject2.getString("state").toUpperCase(), string2, jSONObject2.optString("trace_id")));
    }
}

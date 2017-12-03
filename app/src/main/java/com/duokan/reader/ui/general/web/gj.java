package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

import org.json.JSONObject;

class gj implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    gj(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
        String string = jSONObject.getString("msgid");
        String string2 = jSONObject.getJSONObject("params").getString("bookUuid");
        a.a().b(string2, false, new gk(this, string2, string));
    }
}

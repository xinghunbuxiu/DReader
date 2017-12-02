package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.core.sys.t;
import com.duokan.reader.common.i;

import org.json.JSONObject;

class ef implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    ef(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
        String string = jSONObject.getString("msgid");
        jSONObject = jSONObject.getJSONObject("params");
        String b = i.b(jSONObject, "hint");
        String b2 = i.b(jSONObject, "confirm");
        String b3 = i.b(jSONObject, "inputted");
        Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("multi", true));
        a egVar = new eg(this, string);
        if (valueOf.booleanValue()) {
            t.a(new eh(this, b2, b3, b, egVar));
        } else {
            t.a(new el(this, b, b3, b2, egVar));
        }
    }
}

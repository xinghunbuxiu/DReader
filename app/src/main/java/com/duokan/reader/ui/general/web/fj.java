package com.duokan.reader.ui.general.web;

import com.duokan.c.j;
import com.duokan.core.sys.as;
import com.duokan.reader.common.i;

import org.json.JSONObject;

class fj implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    fj(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
        String string = jSONObject.getString("msgid");
        jSONObject = jSONObject.getJSONObject("params");
        String b = i.b(jSONObject, "title");
        String b2 = i.b(jSONObject, "prompt");
        String a = i.a(jSONObject, "cancel", this.b.b.getContext().getString(j.general__shared__cancel));
        this.b.a(new fk(this, b, b2, i.a(jSONObject, "confirm", this.b.b.getContext().getString(j.general__shared__confirm)), a, string));
    }
}

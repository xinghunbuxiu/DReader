package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.common.i;

import org.json.JSONObject;

class fe implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    fe(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
        JSONObject optJSONObject = jSONObject.optJSONObject("flag");
        boolean z = jSONObject.getBoolean("show");
        boolean z2 = jSONObject.getBoolean("focus");
        String b = i.b(jSONObject, "hint");
        String b2 = i.b(jSONObject, "confirm");
        this.b.a(new ff(this, z, optJSONObject, b, i.b(jSONObject, "inputted"), b2, z2));
    }
}

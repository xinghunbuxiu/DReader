package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.common.i;

import org.json.JSONObject;

class cp implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    cp(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
        this.b.a(new cq(this, jSONObject.getBoolean("add"), i.b(jSONObject, "text")));
    }
}

package com.duokan.reader.ui.general.web;

import com.duokan.c.j;
import com.duokan.core.sys.as;
import com.duokan.reader.common.i;

import org.json.JSONObject;

class jr implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    jr(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
        this.b.a(new js(this, jSONObject.getBoolean("show"), i.a(jSONObject, "msg", this.b.pageController.getContext().getString(j.bookcity_store__shared__creating_order)), jSONObject.optBoolean("cancelable", true), jSONObject.optBoolean("now", false)));
    }
}

package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

import org.json.JSONObject;

class dx implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    dx(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        this.b.a(new dy(this, new JSONObject(this.a).getString("msgid")));
    }
}

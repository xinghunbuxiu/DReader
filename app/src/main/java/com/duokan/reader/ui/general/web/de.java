package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

import org.json.JSONObject;

class de implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    de(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        this.b.a(new df(this, new JSONObject(this.a).getString("msgid")));
    }
}

package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

import org.json.JSONObject;

class du implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    du(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        this.b.a(new dv(this, new JSONObject(this.a).getString("msgid")));
    }
}

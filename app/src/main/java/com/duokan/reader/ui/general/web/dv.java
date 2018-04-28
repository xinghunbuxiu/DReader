package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import org.json.JSONObject;

class dv implements as {
    /* renamed from: a */
    final /* synthetic */ String f7748a;
    /* renamed from: b */
    final /* synthetic */ ci f7749b;

    dv(ci ciVar, String str) {
        this.f7749b = ciVar;
        this.f7748a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        this.f7749b.m11016a(new dw(this, new JSONObject(this.f7748a).getString("msgid")));
    }
}

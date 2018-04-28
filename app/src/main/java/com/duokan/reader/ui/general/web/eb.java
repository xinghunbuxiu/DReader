package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import org.json.JSONObject;

class eb implements as {
    /* renamed from: a */
    final /* synthetic */ String f7761a;
    /* renamed from: b */
    final /* synthetic */ ci f7762b;

    eb(ci ciVar, String str) {
        this.f7762b = ciVar;
        this.f7761a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        this.f7762b.m11016a(new ec(this, new JSONObject(this.f7761a).getString("msgid")));
    }
}

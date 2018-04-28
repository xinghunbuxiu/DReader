package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import org.json.JSONObject;

class ee implements as {
    /* renamed from: a */
    final /* synthetic */ String f7766a;
    /* renamed from: b */
    final /* synthetic */ ci f7767b;

    ee(ci ciVar, String str) {
        this.f7767b = ciVar;
        this.f7766a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        this.f7767b.m11016a(new ef(this, new JSONObject(this.f7766a).getString("msgid")));
    }
}

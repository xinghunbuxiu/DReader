package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import org.json.JSONObject;

class dy implements as {
    /* renamed from: a */
    final /* synthetic */ String f7753a;
    /* renamed from: b */
    final /* synthetic */ ci f7754b;

    dy(ci ciVar, String str) {
        this.f7754b = ciVar;
        this.f7753a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        this.f7754b.m11016a(new dz(this, new JSONObject(this.f7753a).getString("msgid")));
    }
}

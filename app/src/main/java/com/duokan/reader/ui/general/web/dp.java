package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import org.json.JSONObject;

class dp implements as {
    /* renamed from: a */
    final /* synthetic */ String f7739a;
    /* renamed from: b */
    final /* synthetic */ ci f7740b;

    dp(ci ciVar, String str) {
        this.f7740b = ciVar;
        this.f7739a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        this.f7740b.m11016a(new dq(this, new JSONObject(this.f7739a).getString("msgid")));
    }
}

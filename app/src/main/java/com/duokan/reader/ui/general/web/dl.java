package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import org.json.JSONObject;

class dl implements as {
    /* renamed from: a */
    final /* synthetic */ String f7733a;
    /* renamed from: b */
    final /* synthetic */ ci f7734b;

    dl(ci ciVar, String str) {
        this.f7734b = ciVar;
        this.f7733a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        this.f7734b.m11016a(new dm(this, new JSONObject(this.f7733a).getString("msgid")));
    }
}

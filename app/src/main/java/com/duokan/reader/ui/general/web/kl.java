package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.C0797b;
import org.json.JSONObject;

class kl implements as {
    /* renamed from: a */
    final /* synthetic */ String f8104a;
    /* renamed from: b */
    final /* synthetic */ ci f8105b;

    kl(ci ciVar, String str) {
        this.f8105b = ciVar;
        this.f8104a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        C0797b.m3706a(new JSONObject(this.f8104a)).m3707a();
    }
}

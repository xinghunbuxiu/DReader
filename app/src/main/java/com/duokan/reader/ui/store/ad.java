package com.duokan.reader.ui.store;

import com.duokan.reader.common.webservices.duokan.C0629b;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

class ad implements C0666x {
    /* renamed from: a */
    final /* synthetic */ String f11307a;
    /* renamed from: b */
    final /* synthetic */ String f11308b;
    /* renamed from: c */
    final /* synthetic */ an f11309c;
    /* renamed from: d */
    final /* synthetic */ C1502o f11310d;

    ad(C1502o c1502o, String str, String str2, an anVar) {
        this.f11310d = c1502o;
        this.f11307a = str;
        this.f11308b = str2;
        this.f11309c = anVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        new ae(this, C0629b.f2117a, c0672a).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f11309c.mo1983a(this.f11307a, this.f11308b, null);
    }
}

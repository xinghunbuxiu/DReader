package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.duokan.ae;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;

class ag implements C0666x {
    /* renamed from: a */
    final /* synthetic */ int f5497a;
    /* renamed from: b */
    final /* synthetic */ int f5498b;
    /* renamed from: c */
    final /* synthetic */ as f5499c;
    /* renamed from: d */
    final /* synthetic */ boolean f5500d;
    /* renamed from: e */
    final /* synthetic */ DkMessagesManager f5501e;

    ag(DkMessagesManager dkMessagesManager, int i, int i2, as asVar, boolean z) {
        this.f5501e = dkMessagesManager;
        this.f5497a = i;
        this.f5498b = i2;
        this.f5499c = asVar;
        this.f5500d = z;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f5501e.f5479j = new al(c0672a);
        new ah(this, this.f5501e.f5479j.f2360a, ae.f2100a, this.f5501e.f5479j).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f5499c.mo1179a(new C1151k[0], "");
    }
}

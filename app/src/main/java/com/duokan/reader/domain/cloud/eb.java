package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;

class eb implements C0666x {
    /* renamed from: a */
    final /* synthetic */ long f3913a;
    /* renamed from: b */
    final /* synthetic */ int f3914b;
    /* renamed from: c */
    final /* synthetic */ ee f3915c;
    /* renamed from: d */
    final /* synthetic */ boolean f3916d;
    /* renamed from: e */
    final /* synthetic */ DkUserReadBookManager f3917e;

    eb(DkUserReadBookManager dkUserReadBookManager, long j, int i, ee eeVar, boolean z) {
        this.f3917e = dkUserReadBookManager;
        this.f3913a = j;
        this.f3914b = i;
        this.f3915c = eeVar;
        this.f3916d = z;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3917e.f3622f = new al(c0672a);
        al d = this.f3917e.f3622f;
        new ec(this, d.f2360a, C0643q.f2173a, d).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3915c.mo1156a(str);
    }
}

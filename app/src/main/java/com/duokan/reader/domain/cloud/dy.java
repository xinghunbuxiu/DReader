package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;

class dy implements C0666x {
    /* renamed from: a */
    final /* synthetic */ ef f3895a;
    /* renamed from: b */
    final /* synthetic */ String f3896b;
    /* renamed from: c */
    final /* synthetic */ DkUserReadBookManager f3897c;

    dy(DkUserReadBookManager dkUserReadBookManager, ef efVar, String str) {
        this.f3897c = dkUserReadBookManager;
        this.f3895a = efVar;
        this.f3896b = str;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3897c.f3622f = new al(c0672a);
        al d = this.f3897c.f3622f;
        new dz(this, d.f2360a, C0643q.f2173a, d).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3895a.mo1922a(str);
    }
}

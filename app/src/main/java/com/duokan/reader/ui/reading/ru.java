package com.duokan.reader.ui.reading;

import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.PagesView;
import com.duokan.reader.ui.general.fx;
import com.duokan.reader.ui.general.gc;

class ru implements fx {
    /* renamed from: a */
    final /* synthetic */ qr f10917a;

    ru(qr qrVar) {
        this.f10917a = qrVar;
    }

    /* renamed from: a */
    public void mo2478a(PagesView pagesView) {
        this.f10917a.m12817A().prompt(this.f10917a.getString(C0258j.reading__shared__reach_first_page));
    }

    /* renamed from: b */
    public void mo2480b(PagesView pagesView) {
        this.f10917a.m12817A().prompt(this.f10917a.getString(C0258j.reading__shared__reach_last_page));
    }

    /* renamed from: a */
    public void mo2479a(PagesView pagesView, gc gcVar) {
        this.f10917a.m12830a((gs) gcVar);
    }

    /* renamed from: b */
    public void mo2481b(PagesView pagesView, gc gcVar) {
        this.f10917a.m12836b((gs) gcVar);
    }
}

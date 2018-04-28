package com.duokan.reader.ui.reading;

class mf implements ml {
    /* renamed from: a */
    final /* synthetic */ mg f10624a;
    /* renamed from: b */
    final /* synthetic */ mc f10625b;

    mf(mc mcVar, mg mgVar) {
        this.f10625b = mcVar;
        this.f10624a = mgVar;
    }

    /* renamed from: a */
    public void mo2426a() {
        this.f10625b.f10618b.removeView(this.f10625b.f10619c.mo2270b());
        this.f10625b.f10619c = null;
        this.f10625b.f10620d.m1607a(false);
        this.f10624a.mo2503a();
        this.f10625b.f10618b.getShowingPagesView().setEnabled(true);
        this.f10625b.f10617a.mo2040a(0, 12);
    }

    /* renamed from: b */
    public void mo2428b() {
        this.f10624a.mo2504b();
    }

    /* renamed from: c */
    public void mo2429c() {
        this.f10624a.mo2505c();
    }

    /* renamed from: a */
    public void mo2427a(boolean z) {
        this.f10625b.f10618b.getShowingPagesView().setEnabled(!z);
    }
}

package com.duokan.reader.ui.reading;

import com.duokan.core.app.ag;
import com.duokan.core.app.ah;

class aen implements ah {
    /* renamed from: a */
    final /* synthetic */ Runnable f9587a;
    /* renamed from: b */
    final /* synthetic */ adz f9588b;

    aen(adz adz, Runnable runnable) {
        this.f9588b = adz;
        this.f9587a = runnable;
    }

    /* renamed from: a */
    public void mo1562a(ag agVar) {
        this.f9588b.f9558r = true;
        this.f9587a.run();
    }

    /* renamed from: b */
    public void mo1567b(ag agVar) {
        this.f9588b.f9558r = false;
        this.f9588b.m13446b();
        this.f9588b.f9541a.be();
    }

    /* renamed from: c */
    public void mo1565c(ag agVar) {
        this.f9588b.f9558r = false;
        this.f9588b.m13446b();
    }
}

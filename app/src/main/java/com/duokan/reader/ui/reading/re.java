package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.general.gc;

class re implements Runnable {
    /* renamed from: a */
    final /* synthetic */ gc f10887a;
    /* renamed from: b */
    final /* synthetic */ qr f10888b;

    re(qr qrVar, gc gcVar) {
        this.f10888b = qrVar;
        this.f10887a = gcVar;
    }

    public void run() {
        if (this.f10888b.f9279c.mo2007X() == this.f10887a) {
            this.f10888b.mo1980a(this.f10887a);
        }
    }
}

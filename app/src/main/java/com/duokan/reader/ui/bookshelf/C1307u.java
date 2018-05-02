package com.duokan.reader.ui.bookshelf;

import org.apache.http.HttpStatus;

/* renamed from: com.duokan.reader.ui.bookshelf.u */
class C1307u implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1306t f6737a;

    C1307u(C1306t c1306t) {
        this.f6737a = c1306t;
    }

    public void run() {
        this.f6737a.f6736c.f6486f.scrollBy(0, this.f6737a.f6736c.f6489i.getHeight());
        if (this.f6737a.f6734a == 0 && this.f6737a.f6735b) {
            this.f6737a.f6736c.f6486f.m1251b(0, -this.f6737a.f6736c.f6489i.getHeight(), HttpStatus.SC_MULTIPLE_CHOICES, new C1308v(this), null);
        }
    }
}

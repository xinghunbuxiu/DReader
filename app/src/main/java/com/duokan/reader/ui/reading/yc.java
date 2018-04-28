package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.kh;
import com.duokan.reader.domain.document.sbk.C0969f;

class yc implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f11183a;
    /* renamed from: b */
    final /* synthetic */ yb f11184b;

    yc(yb ybVar, int i) {
        this.f11184b = ybVar;
        this.f11183a = i;
    }

    public void run() {
        if (!this.f11184b.f11182a.q) {
            C0969f b = this.f11184b.f11182a.m15076C();
            this.f11184b.f11182a.r = this.f11184b.f11182a.f.m4242o();
            this.f11184b.f11182a.s = this.f11184b.f11182a.f.m4243p();
            if (an.m3740a(this.f11183a, 2048) && ((kh) this.f11184b.f11182a.f).m4830a(b.m7179B())) {
                if (b.m7180C() != ((kh) this.f11184b.f11182a.f).bb()) {
                    b.mo1219a(null);
                    this.f11184b.mo2185a(true);
                } else {
                    this.f11184b.mo2159j(true);
                }
            }
            if (an.m3740a(this.f11183a, 16)) {
                this.f11184b.mo2159j(true);
            }
        }
    }
}

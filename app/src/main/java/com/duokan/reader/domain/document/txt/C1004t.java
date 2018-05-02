package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.C0808w;
import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.document.txt.t */
class C1004t implements Runnable {
    /* renamed from: a */
    static final /* synthetic */ boolean f4999a = (!C1000p.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ C0987c f5000b;
    /* renamed from: c */
    final /* synthetic */ C1000p f5001c;

    C1004t(C1000p c1000p, C0987c c0987c) {
        this.f5001c = c1000p;
        this.f5000b = c0987c;
    }

    public void run() {
        if (!this.f5001c.a) {
            Iterator it = this.f5001c.e.iterator();
            while (it.hasNext()) {
                C0808w c0808w = (C0808w) it.next();
                if (f4999a || c0808w != null) {
                    c0808w.mo1053d(this.f5001c);
                } else {
                    throw new AssertionError();
                }
            }
        }
        this.f5000b.mo1261g();
    }
}

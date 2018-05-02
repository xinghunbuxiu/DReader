package com.duokan.reader.domain.document.epub;

import com.duokan.reader.domain.document.C0808w;
import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.document.epub.w */
class C0956w implements Runnable {
    /* renamed from: a */
    static final /* synthetic */ boolean f4746a = (!C0952s.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ C0934e f4747b;
    /* renamed from: c */
    final /* synthetic */ C0952s f4748c;

    C0956w(C0952s c0952s, C0934e c0934e) {
        this.f4748c = c0952s;
        this.f4747b = c0934e;
    }

    public void run() {
        if (!this.f4748c.a) {
            Iterator it = this.f4748c.e.iterator();
            while (it.hasNext()) {
                C0808w c0808w = (C0808w) it.next();
                if (f4746a || c0808w != null) {
                    c0808w.mo1053d(this.f4748c);
                } else {
                    throw new AssertionError();
                }
            }
        }
        this.f4747b.mo1261g();
    }
}

package com.duokan.reader.domain.document.sbk;

import com.duokan.reader.domain.document.C0808w;
import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.document.sbk.i */
class C0972i implements Runnable {
    /* renamed from: a */
    static final /* synthetic */ boolean f4823a = (!C0969f.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ C0966c f4824b;
    /* renamed from: c */
    final /* synthetic */ C0969f f4825c;

    C0972i(C0969f c0969f, C0966c c0966c) {
        this.f4825c = c0969f;
        this.f4824b = c0966c;
    }

    public void run() {
        if (!this.f4825c.a) {
            Iterator it = this.f4825c.e.iterator();
            while (it.hasNext()) {
                C0808w c0808w = (C0808w) it.next();
                if (f4823a || c0808w != null) {
                    c0808w.mo1053d(this.f4825c);
                } else {
                    throw new AssertionError();
                }
            }
        }
        this.f4824b.mo1261g();
    }
}

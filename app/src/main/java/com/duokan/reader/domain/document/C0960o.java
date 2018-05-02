package com.duokan.reader.domain.document;

import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.document.o */
class C0960o implements Runnable {
    /* renamed from: a */
    static final /* synthetic */ boolean f4755a = (!C0903n.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ C0903n f4756b;

    C0960o(C0903n c0903n) {
        this.f4756b = c0903n;
    }

    public void run() {
        Iterator it = this.f4756b.f4277e.iterator();
        while (it.hasNext()) {
            C0808w c0808w = (C0808w) it.next();
            if (f4755a || c0808w != null) {
                c0808w.mo1049a(this.f4756b);
            } else {
                throw new AssertionError();
            }
        }
        if (this.f4756b.f4273a) {
            this.f4756b.mo1251t();
        } else {
            this.f4756b.f4275c = true;
        }
    }
}

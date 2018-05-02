package com.duokan.reader.domain.document;

import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.document.q */
class C0962q implements Runnable {
    /* renamed from: a */
    static final /* synthetic */ boolean f4759a = (!C0903n.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ C0903n f4760b;

    C0962q(C0903n c0903n) {
        this.f4760b = c0903n;
    }

    public void run() {
        Iterator it = this.f4760b.f4277e.iterator();
        while (it.hasNext()) {
            C0808w c0808w = (C0808w) it.next();
            if (f4759a || c0808w != null) {
                c0808w.mo1052c(this.f4760b);
            } else {
                throw new AssertionError();
            }
        }
    }
}

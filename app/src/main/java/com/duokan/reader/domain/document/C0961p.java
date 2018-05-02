package com.duokan.reader.domain.document;

import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.document.p */
class C0961p implements Runnable {
    /* renamed from: a */
    static final /* synthetic */ boolean f4757a = (!C0903n.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ C0903n f4758b;

    C0961p(C0903n c0903n) {
        this.f4758b = c0903n;
    }

    public void run() {
        Iterator it = this.f4758b.f4277e.iterator();
        while (it.hasNext()) {
            C0808w c0808w = (C0808w) it.next();
            if (f4757a || c0808w != null) {
                c0808w.mo1051b(this.f4758b);
            } else {
                throw new AssertionError();
            }
        }
    }
}

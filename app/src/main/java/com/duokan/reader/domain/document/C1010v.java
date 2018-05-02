package com.duokan.reader.domain.document;

import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.document.v */
class C1010v implements Runnable {
    /* renamed from: a */
    static final /* synthetic */ boolean f5017a = (!C0903n.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ aa f5018b;
    /* renamed from: c */
    final /* synthetic */ C0903n f5019c;

    C1010v(C0903n c0903n, aa aaVar) {
        this.f5019c = c0903n;
        this.f5018b = aaVar;
    }

    public void run() {
        if (!this.f5019c.f4273a) {
            Iterator it = this.f5019c.f4277e.iterator();
            while (it.hasNext()) {
                C0808w c0808w = (C0808w) it.next();
                if (f5017a || c0808w != null) {
                    c0808w.mo1050a(this.f5019c, this.f5018b);
                } else {
                    throw new AssertionError();
                }
            }
        }
    }
}

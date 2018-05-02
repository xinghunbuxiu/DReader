package com.duokan.reader.domain.document.p045a;

import com.duokan.reader.domain.document.C0808w;
import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.document.a.g */
class C0907g implements Runnable {
    /* renamed from: a */
    static final /* synthetic */ boolean f4296a = (!C0904d.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ C0900b f4297b;
    /* renamed from: c */
    final /* synthetic */ C0904d f4298c;

    C0907g(C0904d c0904d, C0900b c0900b) {
        this.f4298c = c0904d;
        this.f4297b = c0900b;
    }

    public void run() {
        if (!this.f4298c.a) {
            Iterator it = this.f4298c.e.iterator();
            while (it.hasNext()) {
                C0808w c0808w = (C0808w) it.next();
                if (f4296a || c0808w != null) {
                    c0808w.mo1053d(this.f4298c);
                } else {
                    throw new AssertionError();
                }
            }
        }
        this.f4297b.mo1261g();
    }
}

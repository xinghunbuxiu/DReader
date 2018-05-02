package com.duokan.reader.domain.document;

import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.document.s */
class C0964s implements Runnable {
    /* renamed from: a */
    static final /* synthetic */ boolean f4764a = (!C0903n.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ as f4765b;
    /* renamed from: c */
    final /* synthetic */ C0903n f4766c;

    C0964s(C0903n c0903n, as asVar) {
        this.f4766c = c0903n;
        this.f4765b = asVar;
    }

    public void run() {
        if (!this.f4766c.f4273a && !this.f4765b.mo1283F()) {
            Iterator it = this.f4766c.f4278f.iterator();
            while (it.hasNext()) {
                at atVar = (at) it.next();
                if (f4764a || atVar != null) {
                    atVar.mo1225b(this.f4766c, this.f4765b);
                } else {
                    throw new AssertionError();
                }
            }
        }
    }
}

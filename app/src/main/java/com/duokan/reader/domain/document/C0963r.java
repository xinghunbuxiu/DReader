package com.duokan.reader.domain.document;

import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.document.r */
class C0963r implements Runnable {
    /* renamed from: a */
    static final /* synthetic */ boolean f4761a = (!C0903n.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ as f4762b;
    /* renamed from: c */
    final /* synthetic */ C0903n f4763c;

    C0963r(C0903n c0903n, as asVar) {
        this.f4763c = c0903n;
        this.f4762b = asVar;
    }

    public void run() {
        if (!this.f4763c.f4273a && !this.f4762b.mo1283F()) {
            Iterator it = this.f4763c.f4278f.iterator();
            while (it.hasNext()) {
                at atVar = (at) it.next();
                if (f4761a || atVar != null) {
                    atVar.mo1221a(this.f4763c, this.f4762b);
                } else {
                    throw new AssertionError();
                }
            }
        }
    }
}

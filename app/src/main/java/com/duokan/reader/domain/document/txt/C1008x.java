package com.duokan.reader.domain.document.txt;

import com.duokan.core.sys.UIdleHandler;
import com.duokan.reader.domain.document.bc;
import java.util.Iterator;
import java.util.concurrent.Semaphore;

/* renamed from: com.duokan.reader.domain.document.txt.x */
class C1008x extends au {
    /* renamed from: h */
    final /* synthetic */ C1000p f5014h;
    /* renamed from: n */
    private C0987c f5015n = null;

    public C1008x(C1000p c1000p, ae aeVar, ad adVar, Semaphore semaphore) {
        this.f5014h = c1000p;
        super(aeVar, adVar, semaphore);
    }

    /* renamed from: c */
    public boolean mo1272c() {
        if (this.b) {
            return false;
        }
        synchronized (this.f5014h) {
            if (this.a) {
                Object a = UIdleHandler.getCurrentThread();
                Iterator it = this.f5014h.f4981l.iterator();
                while (it.hasNext()) {
                    bc bcVar = (bc) it.next();
                    if (bcVar == this) {
                        return false;
                    } else if (bcVar.m5838a(a)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    /* renamed from: e */
    public C0987c mo1469e() {
        return this.f5015n;
    }

    /* renamed from: f */
    public long mo1470f() {
        return this.f5015n.mo1256b();
    }
}

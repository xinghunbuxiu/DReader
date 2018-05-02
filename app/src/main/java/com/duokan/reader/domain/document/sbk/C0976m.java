package com.duokan.reader.domain.document.sbk;

import com.duokan.core.sys.UIdleHandler;
import com.duokan.reader.domain.document.bc;
import java.util.Iterator;
import java.util.concurrent.Semaphore;

/* renamed from: com.duokan.reader.domain.document.sbk.m */
class C0976m extends SbkTypesettingContext {
    /* renamed from: h */
    final /* synthetic */ C0969f f4837h;
    /* renamed from: n */
    private C0966c f4838n = null;

    public C0976m(C0969f c0969f, C0978s c0978s, C0977p c0977p, Semaphore semaphore) {
        this.f4837h = c0969f;
        super(c0978s, c0977p, semaphore);
    }

    /* renamed from: c */
    public boolean mo1272c() {
        if (this.b) {
            return false;
        }
        synchronized (this.f4837h) {
            if (this.a) {
                Object a = UIdleHandler.getCurrentThread();
                Iterator it = this.f4837h.f4811l.iterator();
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
    public C0966c mo1453e() {
        return this.f4838n;
    }
}

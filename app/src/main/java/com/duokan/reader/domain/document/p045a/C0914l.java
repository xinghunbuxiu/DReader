package com.duokan.reader.domain.document.p045a;

import com.duokan.core.sys.UIdleHandler;
import com.duokan.reader.domain.document.bc;
import java.util.Iterator;
import java.util.concurrent.Semaphore;

/* renamed from: com.duokan.reader.domain.document.a.l */
class C0914l extends ah {
    /* renamed from: h */
    final /* synthetic */ C0904d f4323h;
    /* renamed from: n */
    private C0900b f4324n = null;

    public C0914l(C0904d c0904d, C0920r c0920r, C0918q c0918q, Semaphore semaphore) {
        this.f4323h = c0904d;
        super(c0920r, c0918q, semaphore);
    }

    /* renamed from: c */
    public boolean mo1272c() {
        if (this.b) {
            return false;
        }
        synchronized (this.f4323h) {
            if (this.a) {
                Object a = UIdleHandler.getCurrentThread();
                Iterator it = this.f4323h.f4284l.iterator();
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
    public C0900b mo1273e() {
        return this.f4324n;
    }

    /* renamed from: a */
    public int mo1270a(C0925v c0925v) {
        if (!this.e.mo1274c()) {
            return this.e.f4330a;
        }
        return this.f4323h.f4283k.mo1262h().getPageWidth(C0916p.m6078a(this.f4323h.f4283k.mo1262h(), (C0921s) c0925v));
    }

    /* renamed from: b */
    public int mo1271b(C0925v c0925v) {
        if (!this.e.mo1274c()) {
            return this.e.f4331b;
        }
        return this.f4323h.f4283k.mo1262h().getPageHeight(C0916p.m6078a(this.f4323h.f4283k.mo1262h(), (C0921s) c0925v));
    }
}

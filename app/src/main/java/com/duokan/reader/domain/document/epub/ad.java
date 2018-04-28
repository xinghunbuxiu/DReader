package com.duokan.reader.domain.document.epub;

import com.duokan.core.sys.UIdleHandler;
import com.duokan.reader.domain.document.bc;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;

class ad extends EpubTypesettingContext {
    /* renamed from: h */
    final /* synthetic */ C0952s f4475h;
    /* renamed from: p */
    private C0934e f4476p = null;

    public ad(C0952s c0952s, ap apVar, am amVar, Semaphore semaphore) {
        this.f4475h = c0952s;
        super(apVar, amVar, semaphore);
    }

    /* renamed from: c */
    public boolean mo1272c() {
        if (this.b) {
            return false;
        }
        synchronized (this.f4475h) {
            if (this.a) {
                Object a = UIdleHandler.getCurrentThread();
                Iterator it = this.f4475h.f4725l.iterator();
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
    public C0934e mo1369e() {
        return this.f4476p;
    }

    /* renamed from: f */
    public void mo1370f() {
        this.f4475h.m6980M();
    }

    /* renamed from: g */
    public List<av> mo1371g() {
        return this.f4475h.m6981N();
    }

    /* renamed from: h */
    public List<av> mo1372h() {
        return this.f4475h.m6982O();
    }

    /* renamed from: a */
    public av mo1368a(String str, boolean z) {
        if (this.f4475h.f4723j == null) {
            return null;
        }
        av a = this.f4475h.f4723j.mo1060a(new aw(this.f4476p.mo1365h().getResource(str)), z);
        return (a == null || !a.mo1072h()) ? null : a;
    }
}

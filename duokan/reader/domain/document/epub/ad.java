package com.duokan.reader.domain.document.epub;

import com.duokan.reader.domain.document.bc;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;

class ad extends EpubTypesettingContext {
    final /* synthetic */ s h;
    private e p = null;

    public ad(s sVar, ap apVar, am amVar, Semaphore semaphore) {
        this.h = sVar;
        super(apVar, amVar, semaphore);
    }

    public boolean c() {
        if (this.b) {
            return false;
        }
        synchronized (this.h) {
            if (this.a) {
                Object a = j.a();
                Iterator it = this.h.l.iterator();
                while (it.hasNext()) {
                    bc bcVar = (bc) it.next();
                    if (bcVar == this) {
                        return false;
                    } else if (bcVar.a(a)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    public e e() {
        return this.p;
    }

    public void f() {
        this.h.M();
    }

    public List g() {
        return this.h.N();
    }

    public List h() {
        return this.h.O();
    }

    public av a(String str, boolean z) {
        if (this.h.j == null) {
            return null;
        }
        av a = this.h.j.a(new aw(this.p.h().getResource(str)), z);
        return (a == null || !a.h()) ? null : a;
    }
}

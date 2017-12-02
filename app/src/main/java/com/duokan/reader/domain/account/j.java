package com.duokan.reader.domain.account;

import com.duokan.core.a.n;
import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.t;

class j implements e {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public void a(a aVar) {
        a.c().b(t.a());
        synchronized (this.a) {
            this.a.i.put(aVar.getClass(), aVar);
        }
    }

    public void b(a aVar) {
        a.c().b(t.a());
        this.a.c(aVar);
    }

    public void c(a aVar) {
        this.a.d(aVar);
    }

    public n a() {
        return this.a.e;
    }

    public n b() {
        return this.a.f;
    }

    public String a(int i) {
        return this.a.c.getString(i);
    }

    public a a(Class cls) {
        return this.a.b(cls);
    }
}

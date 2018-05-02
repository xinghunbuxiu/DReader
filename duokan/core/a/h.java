package com.duokan.core.a;

class h implements l {
    final /* synthetic */ l a;
    final /* synthetic */ a b;

    h(a aVar, l lVar) {
        this.b = aVar;
        this.a = lVar;
    }

    public boolean a(n nVar) {
        boolean a;
        nVar.b();
        try {
            a = this.a.a(nVar);
            nVar.f();
        } catch (Throwable th) {
            a = false;
        } finally {
            nVar.c();
        }
        return a;
    }
}

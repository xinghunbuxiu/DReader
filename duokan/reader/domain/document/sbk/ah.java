package com.duokan.reader.domain.document.sbk;

import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;

public class ah extends bb {
    private final b a;
    private final b b;

    public /* synthetic */ av g() {
        return j();
    }

    public /* synthetic */ av h() {
        return k();
    }

    protected ah() {
        this(new b(0, 0, 0), new b(0, 0, 0));
    }

    protected ah(b bVar, b bVar2) {
        this.a = bVar;
        this.b = bVar2;
    }

    protected static ah a(ah ahVar, ah ahVar2) {
        if (ahVar.f()) {
            return ahVar2;
        }
        if (ahVar2.f()) {
            return ahVar;
        }
        return new ah(ahVar.j().a(ahVar2.j()) ? ahVar.j() : ahVar2.j(), ahVar.k().c(ahVar2.k()) ? ahVar.k() : ahVar2.k());
    }

    protected static ah b(ah ahVar, ah ahVar2) {
        if (ahVar.f() || ahVar2.f()) {
            return ahVar;
        }
        return new ah(ahVar.j().a(ahVar2.j()) ? ahVar2.j() : ahVar.j(), ahVar.k().a(ahVar2.k()) ? ahVar.k() : ahVar2.k());
    }

    public boolean a() {
        return true;
    }

    public boolean c() {
        return false;
    }

    public boolean e() {
        return true;
    }

    public boolean a(long j) {
        return true;
    }

    public b j() {
        return this.a;
    }

    public b k() {
        return this.b;
    }

    public bb a(bb bbVar) {
        return a(this, (ah) bbVar);
    }

    public bb b(bb bbVar) {
        return b(this, (ah) bbVar);
    }
}

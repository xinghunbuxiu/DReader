package com.duokan.reader.domain.document.a;

import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;

public class ag extends bb {
    private final a a;
    private final a b;

    public /* synthetic */ av g() {
        return j();
    }

    public /* synthetic */ av h() {
        return k();
    }

    protected ag() {
        this(new a(0, 0, 0), new a(0, 0, 0));
    }

    protected ag(a aVar, a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    protected static ag a(ag agVar, ag agVar2) {
        if (agVar.f()) {
            return agVar2;
        }
        if (agVar2.f()) {
            return agVar;
        }
        return new ag(agVar.j().a(agVar2.j()) ? agVar.j() : agVar2.j(), agVar.k().c(agVar2.k()) ? agVar.k() : agVar2.k());
    }

    protected static ag b(ag agVar, ag agVar2) {
        if (agVar.f() || agVar2.f()) {
            return agVar;
        }
        return new ag(agVar.j().a(agVar2.j()) ? agVar2.j() : agVar.j(), agVar.k().a(agVar2.k()) ? agVar.k() : agVar2.k());
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

    public a j() {
        return this.a;
    }

    public a k() {
        return this.b;
    }

    public bb a(bb bbVar) {
        return a(this, (ag) bbVar);
    }

    public bb b(bb bbVar) {
        return b(this, (ag) bbVar);
    }
}

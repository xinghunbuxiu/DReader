package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;

public class at extends bb {
    private final b a;
    private final b b;

    public /* synthetic */ av g() {
        return j();
    }

    public /* synthetic */ av h() {
        return k();
    }

    protected at() {
        this(new b(0), new b(0));
    }

    protected at(b bVar, b bVar2) {
        this.a = bVar;
        this.b = bVar2;
    }

    protected static at a(at atVar, at atVar2) {
        if (atVar.f()) {
            return atVar2;
        }
        if (atVar2.f()) {
            return atVar;
        }
        return new at(atVar.j().a(atVar2.j()) ? atVar.j() : atVar2.j(), atVar.k().c(atVar2.k()) ? atVar.k() : atVar2.k());
    }

    static at b(at atVar, at atVar2) {
        if (atVar.f() || atVar2.f()) {
            return atVar;
        }
        return new at(atVar.j().a(atVar2.j()) ? atVar2.j() : atVar.j(), atVar.k().a(atVar2.k()) ? atVar.k() : atVar2.k());
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
        return a(this, (at) bbVar);
    }

    public bb b(bb bbVar) {
        return b(this, (at) bbVar);
    }
}

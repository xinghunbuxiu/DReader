package com.duokan.reader.domain.document;

public abstract class h {
    static final /* synthetic */ boolean a = (!h.class.desiredAssertionStatus());

    public abstract String a();

    public abstract void a(String str);

    protected abstract boolean a(g gVar, d dVar);

    public abstract g b(a aVar);

    public abstract g[] b();

    public abstract int c();

    protected h() {
    }

    public g a(a aVar) {
        g b = b(aVar);
        if (b == null) {
            return null;
        }
        return b()[b.d()];
    }

    public g a(g gVar) {
        if (gVar == null) {
            return null;
        }
        return b(b(), gVar);
    }

    public g b(g gVar) {
        if (gVar == null) {
            return null;
        }
        return a(b(), gVar);
    }

    protected g a(g[] gVarArr, g gVar) {
        if (!a && gVarArr == null) {
            throw new AssertionError();
        } else if (a || gVarArr.length > 0) {
            g gVar2 = null;
            for (int length = gVarArr.length - 1; length >= 0; length--) {
                if (gVarArr[length].k()) {
                    if (gVarArr[length].i() > 0) {
                        gVar2 = a(gVarArr[length].j(), gVar);
                    }
                    if (gVar2 != null) {
                        return gVar2;
                    }
                    if (gVarArr[length].c() < gVar.c()) {
                        gVar2 = gVarArr[length];
                    }
                    if (gVar2 != null) {
                        return gVar2;
                    }
                }
            }
            return null;
        } else {
            throw new AssertionError();
        }
    }

    protected g b(g[] gVarArr, g gVar) {
        if (!a && gVarArr == null) {
            throw new AssertionError();
        } else if (a || gVarArr.length > 0) {
            g gVar2 = null;
            for (int i = 0; i < gVarArr.length; i++) {
                if (gVarArr[i].k()) {
                    if (gVarArr[i].c() > gVar.c()) {
                        gVar2 = gVarArr[i];
                    }
                    if (gVar2 != null) {
                        return gVar2;
                    }
                    if (gVarArr[i].i() > 0) {
                        gVar2 = b(gVarArr[i].j(), gVar);
                    }
                    if (gVar2 != null) {
                        return gVar2;
                    }
                }
            }
            return null;
        } else {
            throw new AssertionError();
        }
    }

    protected g a(g[] gVarArr, d dVar) {
        if (!a && gVarArr == null) {
            throw new AssertionError();
        } else if (!a && dVar == null) {
            throw new AssertionError();
        } else if (a || gVarArr.length > 0) {
            g gVar = null;
            for (int i = 0; i < gVarArr.length; i++) {
                if (gVarArr[i].k()) {
                    if (a(gVarArr[i], dVar)) {
                        break;
                    }
                    gVar = gVarArr[i];
                }
            }
            if (gVar == null || gVar.j().length <= 0) {
                return gVar;
            }
            g a = a(gVar.j(), dVar);
            if (a != null) {
                return a;
            }
            return gVar;
        } else {
            throw new AssertionError();
        }
    }
}

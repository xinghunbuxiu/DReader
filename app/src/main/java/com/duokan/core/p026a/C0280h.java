package com.duokan.core.p026a;


class C0280h implements C0273l {
    
    final  C0273l f469a;
    
    final  C0272a f470b;

    C0280h(C0272a c0272a, C0273l c0273l) {
        this.f470b = c0272a;
        this.f469a = c0273l;
    }

    
    public boolean mo379a(C0285n c0285n) {
        boolean a;
        c0285n.m677b();
        try {
            a = this.f469a.mo379a(c0285n);
            c0285n.m681f();
        } catch (Throwable th) {
            a = false;
        } finally {
            c0285n.m678c();
        }
        return a;
    }
}

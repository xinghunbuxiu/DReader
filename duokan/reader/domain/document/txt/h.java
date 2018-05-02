package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.at;

class h implements n {
    final /* synthetic */ f a;

    h(f fVar) {
        this.a = fVar;
    }

    public void a(o oVar) {
        at iVar = new i(this);
        ah ahVar = new ah(this.a.f);
        ahVar.m = false;
        ahVar.n = false;
        ah ahVar2 = new ah(this.a.f);
        ahVar2.l = false;
        ahVar2.n = false;
        this.a.m = new aj(this.a.d, this.a.e.l(), ahVar2, this.a.g, iVar);
        this.a.l = new aj(this.a.d, this.a.e.k(), ahVar, this.a.g, iVar);
        this.a.p = true;
        synchronized (this.a) {
            if (this.a.q != null) {
                this.a.q.countDown();
            }
        }
        this.a.a(new j(this));
    }

    public void b(o oVar) {
    }

    public void c(o oVar) {
    }
}

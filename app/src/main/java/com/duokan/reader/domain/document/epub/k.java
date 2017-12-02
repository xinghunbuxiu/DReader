package com.duokan.reader.domain.document.epub;

import com.duokan.reader.domain.document.at;

class k implements q {
    final /* synthetic */ i a;

    k(i iVar) {
        this.a = iVar;
    }

    public void a(r rVar) {
        at lVar = new l(this);
        au auVar = new au(this.a.f);
        auVar.m = false;
        auVar.r = false;
        auVar.n = false;
        au auVar2 = new au(this.a.f);
        auVar2.l = false;
        auVar2.n = false;
        if (this.a.d.e().h().getWritingMode() == 1) {
            this.a.m = this.a.n = new az(this.a.d, this.a.e.l(), auVar, this.a.g, lVar);
            this.a.l = this.a.o = new az(this.a.d, this.a.e.k(), auVar2, this.a.g, lVar);
        } else {
            this.a.m = this.a.o = new az(this.a.d, this.a.e.l(), auVar2, this.a.g, lVar);
            this.a.l = this.a.n = new az(this.a.d, this.a.e.k(), auVar, this.a.g, lVar);
        }
        this.a.r = true;
        synchronized (this.a) {
            if (this.a.t != null) {
                this.a.t.countDown();
            }
        }
        this.a.a(new m(this));
    }

    public void b(r rVar) {
    }

    public void c(r rVar) {
    }
}

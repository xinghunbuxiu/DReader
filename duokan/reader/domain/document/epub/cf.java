package com.duokan.reader.domain.document.epub;

class cf implements cc {
    final /* synthetic */ h a;
    final /* synthetic */ ay b;
    final /* synthetic */ q c;
    final /* synthetic */ r d;
    final /* synthetic */ EpubTypesettingContext e;

    cf(EpubTypesettingContext epubTypesettingContext, h hVar, ay ayVar, q qVar, r rVar) {
        this.e = epubTypesettingContext;
        this.a = hVar;
        this.b = ayVar;
        this.c = qVar;
        this.d = rVar;
    }

    public void a(cd cdVar) {
        if (!this.a.m()) {
            this.a.a(this.b);
        }
        if (this.c != null) {
            this.c.a(this.d);
        }
        ch chVar = new ch(this.a.k(), null);
        ch chVar2 = new ch(this.a.l(), new cg(this));
        synchronized (this.e) {
            this.e.n.addFirst(chVar2);
            this.e.n.addFirst(chVar);
        }
        this.e.f.release();
        this.e.f.release();
    }

    public void b(cd cdVar) {
        if (this.c != null) {
            this.c.c(this.d);
        }
    }
}

package com.duokan.reader.domain.document.epub;

class cf implements cc {
    /* renamed from: a */
    final /* synthetic */ C0940h f4654a;
    /* renamed from: b */
    final /* synthetic */ ay f4655b;
    /* renamed from: c */
    final /* synthetic */ C0944q f4656c;
    /* renamed from: d */
    final /* synthetic */ C0951r f4657d;
    /* renamed from: e */
    final /* synthetic */ EpubTypesettingContext f4658e;

    cf(EpubTypesettingContext epubTypesettingContext, C0940h c0940h, ay ayVar, C0944q c0944q, C0951r c0951r) {
        this.f4658e = epubTypesettingContext;
        this.f4654a = c0940h;
        this.f4655b = ayVar;
        this.f4656c = c0944q;
        this.f4657d = c0951r;
    }

    /* renamed from: a */
    public void mo1377a(cd cdVar) {
        if (!this.f4654a.m6849m()) {
            this.f4654a.m6838a(this.f4655b);
        }
        if (this.f4656c != null) {
            this.f4656c.mo1437a(this.f4657d);
        }
        ch chVar = new ch(this.f4654a.m6847k(), null);
        ch chVar2 = new ch(this.f4654a.m6848l(), new cg(this));
        synchronized (this.f4658e) {
            this.f4658e.f4456n.addFirst(chVar2);
            this.f4658e.f4456n.addFirst(chVar);
        }
        this.f4658e.f.release();
        this.f4658e.f.release();
    }

    /* renamed from: b */
    public void mo1378b(cd cdVar) {
        if (this.f4656c != null) {
            this.f4656c.mo1439c(this.f4657d);
        }
    }
}

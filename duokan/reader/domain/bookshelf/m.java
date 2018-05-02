package com.duokan.reader.domain.bookshelf;

class m implements u {
    final /* synthetic */ v a;
    final /* synthetic */ c b;
    final /* synthetic */ c c;

    m(c cVar, v vVar, c cVar2) {
        this.c = cVar;
        this.a = vVar;
        this.b = cVar2;
    }

    public void a() {
        this.a.a();
        d();
    }

    public void b() {
        this.a.b();
        d();
    }

    public void c() {
        this.a.c();
        d();
    }

    private void d() {
        this.c.K.remove(this.a);
        this.c.L.remove(Long.valueOf(this.a.a.aF()));
        this.c.c(this.b);
    }
}

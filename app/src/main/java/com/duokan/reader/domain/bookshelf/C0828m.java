package com.duokan.reader.domain.bookshelf;

/* renamed from: com.duokan.reader.domain.bookshelf.m */
class C0828m implements C0806u {
    /* renamed from: a */
    final /* synthetic */ C0836v f3567a;
    /* renamed from: b */
    final /* synthetic */ C0800c f3568b;
    /* renamed from: c */
    final /* synthetic */ C0800c f3569c;

    C0828m(C0800c c0800c, C0836v c0836v, C0800c c0800c2) {
        this.f3569c = c0800c;
        this.f3567a = c0836v;
        this.f3568b = c0800c2;
    }

    /* renamed from: a */
    public void mo1044a() {
        this.f3567a.m4971a();
        m4963d();
    }

    /* renamed from: b */
    public void mo1045b() {
        this.f3567a.m4972b();
        m4963d();
    }

    /* renamed from: c */
    public void mo1046c() {
        this.f3567a.m4973c();
        m4963d();
    }

    /* renamed from: d */
    private void m4963d() {
        this.f3569c.f2901K.remove(this.f3567a);
        this.f3569c.f2902L.remove(Long.valueOf(this.f3567a.f3581a.aH()));
        this.f3569c.m4139c(this.f3568b);
    }
}

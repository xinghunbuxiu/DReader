package com.duokan.core.ui;

class dk extends dq {
    final /* synthetic */ di a;

    public /* synthetic */ dp c() {
        return b();
    }

    public /* synthetic */ dp d() {
        return a();
    }

    public dk(di diVar, dl dlVar, dl dlVar2, long j, Runnable runnable, Runnable runnable2) {
        this.a = diVar;
        super(diVar, new dl(dlVar), new dl(dlVar2), j, runnable, runnable2);
    }

    public dl a() {
        return (dl) super.d();
    }

    public dl b() {
        return (dl) super.c();
    }

    public boolean a(dp dpVar, long j) {
        boolean a = super.a(dpVar, j);
        dl dlVar = (dl) dpVar;
        dl a2 = a();
        dl b = b();
        float e = e();
        float a3 = a2.a() + ((b.a() - a2.a()) * e);
        float b2 = a2.b() + ((b.b() - a2.b()) * e);
        float c = a2.c() + ((b.c() - a2.c()) * e);
        float d = a2.d() + ((b.d() - a2.d()) * e);
        float e2 = ((b.e() - a2.e()) * e) + a2.e();
        dlVar.a(a3);
        dlVar.a(b2, c, d, e2);
        return a;
    }
}

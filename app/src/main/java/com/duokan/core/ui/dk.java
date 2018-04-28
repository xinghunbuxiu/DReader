package com.duokan.core.ui;

class dk extends dq {
    /* renamed from: a */
    final /* synthetic */ di f1157a;

    /* renamed from: c */
    public /* synthetic */ dp mo513c() {
        return m1849b();
    }

    /* renamed from: d */
    public /* synthetic */ dp mo514d() {
        return m1847a();
    }

    public dk(di diVar, dl dlVar, dl dlVar2, long j, Runnable runnable, Runnable runnable2) {
        this.f1157a = diVar;
        super(diVar, new dl(dlVar), new dl(dlVar2), j, runnable, runnable2);
    }

    /* renamed from: a */
    public dl m1847a() {
        return (dl) super.mo514d();
    }

    /* renamed from: b */
    public dl m1849b() {
        return (dl) super.mo513c();
    }

    /* renamed from: a */
    public boolean mo512a(dp dpVar, long j) {
        boolean a = super.mo512a(dpVar, j);
        dl dlVar = (dl) dpVar;
        dl a2 = m1847a();
        dl b = m1849b();
        float e = m1845e();
        float a3 = a2.m1868a() + ((b.m1868a() - a2.m1868a()) * e);
        float b2 = a2.m1872b() + ((b.m1872b() - a2.m1872b()) * e);
        float c = a2.m1873c() + ((b.m1873c() - a2.m1873c()) * e);
        float d = a2.m1874d() + ((b.m1874d() - a2.m1874d()) * e);
        float e2 = ((b.m1875e() - a2.m1875e()) * e) + a2.m1875e();
        dlVar.m1869a(a3);
        dlVar.m1870a(b2, c, d, e2);
        return a;
    }
}

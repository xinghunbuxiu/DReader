package com.duokan.reader.common.p036b;

/* renamed from: com.duokan.reader.common.b.b */
class C0539b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f1799a;
    /* renamed from: b */
    final /* synthetic */ Runnable f1800b;
    /* renamed from: c */
    final /* synthetic */ C0538a f1801c;

    C0539b(C0538a c0538a, boolean z, Runnable runnable) {
        this.f1801c = c0538a;
        this.f1799a = z;
        this.f1800b = runnable;
    }

    public void run() {
        if (this.f1799a) {
            this.f1801c.m2407g();
        }
        if (this.f1800b != null) {
            this.f1800b.run();
        }
    }
}

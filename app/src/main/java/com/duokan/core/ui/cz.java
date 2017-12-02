package com.duokan.core.ui;

class cz implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ cy f;

    cz(cy cyVar, boolean z, int i, int i2, int i3, int i4) {
        this.f = cyVar;
        this.a = z;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public void run() {
        this.f.a(this.a, this.b, this.c, this.d, this.e);
    }
}

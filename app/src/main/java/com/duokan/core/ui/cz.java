package com.duokan.core.ui;

class cz implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f1120a;
    /* renamed from: b */
    final /* synthetic */ int f1121b;
    /* renamed from: c */
    final /* synthetic */ int f1122c;
    /* renamed from: d */
    final /* synthetic */ int f1123d;
    /* renamed from: e */
    final /* synthetic */ int f1124e;
    /* renamed from: f */
    final /* synthetic */ cy f1125f;

    cz(cy cyVar, boolean z, int i, int i2, int i3, int i4) {
        this.f1125f = cyVar;
        this.f1120a = z;
        this.f1121b = i;
        this.f1122c = i2;
        this.f1123d = i3;
        this.f1124e = i4;
    }

    public void run() {
        this.f1125f.m1790a(this.f1120a, this.f1121b, this.f1122c, this.f1123d, this.f1124e);
    }
}

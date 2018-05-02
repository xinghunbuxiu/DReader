package com.duokan.reader.ui.bookshelf;

import java.util.List;

/* renamed from: com.duokan.reader.ui.bookshelf.w */
class C1309w implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ie f6739a;
    /* renamed from: b */
    final /* synthetic */ boolean[] f6740b;
    /* renamed from: c */
    final /* synthetic */ int f6741c;
    /* renamed from: d */
    final /* synthetic */ List f6742d;
    /* renamed from: e */
    final /* synthetic */ boolean f6743e;
    /* renamed from: f */
    final /* synthetic */ boolean f6744f;
    /* renamed from: g */
    final /* synthetic */ boolean f6745g;
    /* renamed from: h */
    final /* synthetic */ C1290g f6746h;

    C1309w(C1290g c1290g, ie ieVar, boolean[] zArr, int i, List list, boolean z, boolean z2, boolean z3) {
        this.f6746h = c1290g;
        this.f6739a = ieVar;
        this.f6740b = zArr;
        this.f6741c = i;
        this.f6742d = list;
        this.f6743e = z;
        this.f6744f = z2;
        this.f6745g = z3;
    }

    public void run() {
        this.f6739a.m9853b(this.f6740b, this.f6741c, this.f6742d, this.f6743e, this.f6744f, this.f6745g);
    }
}

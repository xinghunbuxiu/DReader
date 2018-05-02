package com.duokan.reader.ui.surfing;

/* renamed from: com.duokan.reader.ui.surfing.m */
class C1526m implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f11570a;
    /* renamed from: b */
    final /* synthetic */ Object f11571b;
    /* renamed from: c */
    final /* synthetic */ boolean f11572c;
    /* renamed from: d */
    final /* synthetic */ Runnable f11573d;
    /* renamed from: e */
    final /* synthetic */ C1522i f11574e;

    C1526m(C1522i c1522i, String str, Object obj, boolean z, Runnable runnable) {
        this.f11574e = c1522i;
        this.f11570a = str;
        this.f11571b = obj;
        this.f11572c = z;
        this.f11573d = runnable;
    }

    public void run() {
        int indexOf = this.f11570a.indexOf(47);
        if (indexOf >= 0 && indexOf < this.f11570a.length() - 1) {
            this.f11574e.f11550r.navigate(this.f11570a.substring(indexOf + 1), this.f11571b, this.f11572c, this.f11573d);
        }
    }
}

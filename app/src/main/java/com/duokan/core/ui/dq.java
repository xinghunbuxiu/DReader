package com.duokan.core.ui;

import android.view.animation.AlphaAnimation;
import android.view.animation.Transformation;

class dq {
    /* renamed from: a */
    private final dp f1149a;
    /* renamed from: b */
    final /* synthetic */ di f1150b;
    /* renamed from: c */
    private final dp f1151c;
    /* renamed from: d */
    private final AlphaAnimation f1152d = new AlphaAnimation(0.0f, 1.0f);
    /* renamed from: e */
    private final Transformation f1153e = new Transformation();
    /* renamed from: f */
    private final Runnable f1154f;
    /* renamed from: g */
    private final Runnable f1155g;
    /* renamed from: h */
    private boolean f1156h = false;

    public dq(di diVar, dp dpVar, dp dpVar2, long j, Runnable runnable, Runnable runnable2) {
        this.f1150b = diVar;
        this.f1149a = dpVar;
        this.f1151c = dpVar2;
        this.f1154f = runnable;
        this.f1155g = runnable2;
        this.f1152d.setDuration(j);
        this.f1152d.initialize(0, 0, 0, 0);
        this.f1152d.setAnimationListener(new dr(this, diVar));
    }

    /* renamed from: e */
    public float m1845e() {
        return this.f1153e.getAlpha();
    }

    /* renamed from: d */
    public dp mo514d() {
        return this.f1149a;
    }

    /* renamed from: c */
    public dp mo513c() {
        return this.f1151c;
    }

    /* renamed from: a */
    public boolean mo512a(dp dpVar, long j) {
        if (!this.f1152d.hasStarted()) {
            this.f1152d.start();
        }
        boolean transformation = this.f1152d.getTransformation(j, this.f1153e);
        float alpha = this.f1153e.getAlpha();
        float f = this.f1149a.m1859f() + ((this.f1151c.m1859f() - this.f1149a.m1859f()) * alpha);
        float g = this.f1149a.m1860g() + ((this.f1151c.m1860g() - this.f1149a.m1860g()) * alpha);
        int h = this.f1149a.m1861h() + Math.round(((float) (this.f1151c.m1861h() - this.f1149a.m1861h())) * alpha);
        int i = this.f1149a.m1862i() + Math.round(((float) (this.f1151c.m1862i() - this.f1149a.m1862i())) * alpha);
        float j2 = this.f1149a.m1863j() + ((this.f1151c.m1863j() - this.f1149a.m1863j()) * alpha);
        float k = this.f1149a.m1864k() + ((this.f1151c.m1864k() - this.f1149a.m1864k()) * alpha);
        float l = this.f1149a.m1865l() + ((this.f1151c.m1865l() - this.f1149a.m1865l()) * alpha);
        float m = this.f1149a.m1866m() + ((this.f1151c.m1866m() - this.f1149a.m1866m()) * alpha);
        alpha = (alpha * (this.f1151c.m1867n() - this.f1149a.m1867n())) + this.f1149a.m1867n();
        dpVar.m1852a(f, g);
        dpVar.m1853a(h, i);
        dpVar.m1855b(j2);
        dpVar.m1857c(k);
        dpVar.m1858d(l);
        dpVar.m1856b(m, alpha);
        return transformation;
    }

    /* renamed from: f */
    public void m1846f() {
        if (!this.f1156h) {
            this.f1156h = true;
            this.f1152d.cancel();
        }
    }
}

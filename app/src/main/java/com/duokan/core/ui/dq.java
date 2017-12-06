package com.duokan.core.ui;

import android.view.animation.AlphaAnimation;
import android.view.animation.Transformation;

class dq {
    private final dp a;
    final di b;
    private final dp c;
    private final AlphaAnimation d = new AlphaAnimation(0.0f, 1.0f);
    private final Transformation e = new Transformation();
    private final Runnable f;
    private final Runnable g;
    private boolean h = false;

    public dq(di diVar, dp dpVar, dp dpVar2, long j, Runnable runnable, Runnable runnable2) {
        this.b = diVar;
        this.a = dpVar;
        this.c = dpVar2;
        this.f = runnable;
        this.g = runnable2;
        this.d.setDuration(j);
        this.d.initialize(0, 0, 0, 0);
        this.d.setAnimationListener(new dr(this, diVar));
    }

    public float e() {
        return this.e.getAlpha();
    }

    public dp d() {
        return this.a;
    }

    public dp c() {
        return this.c;
    }

    public boolean a(dp dpVar, long j) {
        if (!this.d.hasStarted()) {
            this.d.start();
        }
        boolean transformation = this.d.getTransformation(j, this.e);
        float alpha = this.e.getAlpha();
        float f = this.a.f() + ((this.c.f() - this.a.f()) * alpha);
        float g = this.a.g() + ((this.c.g() - this.a.g()) * alpha);
        int h = this.a.h() + Math.round(((float) (this.c.h() - this.a.h())) * alpha);
        int i = this.a.i() + Math.round(((float) (this.c.i() - this.a.i())) * alpha);
        float j2 = this.a.j() + ((this.c.j() - this.a.j()) * alpha);
        float k = this.a.k() + ((this.c.k() - this.a.k()) * alpha);
        float l = this.a.l() + ((this.c.l() - this.a.l()) * alpha);
        float m = this.a.m() + ((this.c.m() - this.a.m()) * alpha);
        alpha = (alpha * (this.c.n() - this.a.n())) + this.a.n();
        dpVar.a(f, g);
        dpVar.a(h, i);
        dpVar.b(j2);
        dpVar.c(k);
        dpVar.d(l);
        dpVar.b(m, alpha);
        return transformation;
    }

    public void f() {
        if (!this.h) {
            this.h = true;
            this.d.cancel();
        }
    }
}

package com.duokan.core.ui;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

class ai implements Runnable {
    public int a;
    public aq b;
    public View c;
    public Runnable d;
    public Runnable e;
    public int f;
    public int g;
    public int h;
    public int i;
    public AlphaAnimation j;
    public int[] k;
    public float l;
    public int m;
    public boolean n;
    final /* synthetic */ HatGridView o;

    public void run() {
        Transformation transformation = new Transformation();
        boolean transformation2 = this.j.getTransformation(AnimationUtils.currentAnimationTimeMillis(), transformation);
        this.l = transformation.getAlpha();
        int round = Math.round(((float) this.h) * this.l);
        this.m = Math.round(((float) this.i) * this.l) + round;
        this.o.a.f(this.o.a.getScrollX(), round + this.f);
        for (int i : this.k) {
            if (i / this.o.a.getColumnCount() > this.a / this.o.a.getColumnCount()) {
                this.o.a.b(i, 0, this.m);
            }
        }
        this.b.a();
        if (transformation2) {
            this.o.post(this);
        } else if (this.n) {
            for (int a : this.o.z.k) {
                this.o.a.a(a, false);
            }
            this.o.a.setEnabled(true);
            this.o.removeViewInLayout(this.o.z.b);
            this.o.invalidate();
            this.o.post(this.o.z.e);
            this.o.z = null;
        } else {
            this.o.post(this.o.z.d);
        }
    }
}

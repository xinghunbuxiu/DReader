package com.duokan.core.ui;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

class ai implements Runnable {
    /* renamed from: a */
    public int f902a;
    /* renamed from: b */
    public aq f903b;
    /* renamed from: c */
    public View f904c;
    /* renamed from: d */
    public Runnable f905d;
    /* renamed from: e */
    public Runnable f906e;
    /* renamed from: f */
    public int f907f;
    /* renamed from: g */
    public int f908g;
    /* renamed from: h */
    public int f909h;
    /* renamed from: i */
    public int f910i;
    /* renamed from: j */
    public AlphaAnimation f911j;
    /* renamed from: k */
    public int[] f912k;
    /* renamed from: l */
    public float f913l;
    /* renamed from: m */
    public int f914m;
    /* renamed from: n */
    public boolean f915n;
    /* renamed from: o */
    final /* synthetic */ HatGridView f916o;

    public void run() {
        Transformation transformation = new Transformation();
        boolean transformation2 = this.f911j.getTransformation(AnimationUtils.currentAnimationTimeMillis(), transformation);
        this.f913l = transformation.getAlpha();
        int round = Math.round(((float) this.f909h) * this.f913l);
        this.f914m = Math.round(((float) this.f910i) * this.f913l) + round;
        this.f916o.f811a.m1140f(this.f916o.f811a.getScrollX(), round + this.f907f);
        for (int i : this.f912k) {
            if (i / this.f916o.f811a.getColumnCount() > this.f902a / this.f916o.f811a.getColumnCount()) {
                this.f916o.f811a.m1123b(i, 0, this.f914m);
            }
        }
        this.f903b.m1599a();
        if (transformation2) {
            this.f916o.post(this);
        } else if (this.f915n) {
            for (int a : this.f916o.f836z.f912k) {
                this.f916o.f811a.m1119a(a, false);
            }
            this.f916o.f811a.setEnabled(true);
            this.f916o.removeViewInLayout(this.f916o.f836z.f903b);
            this.f916o.invalidate();
            this.f916o.post(this.f916o.f836z.f906e);
            this.f916o.f836z = null;
        } else {
            this.f916o.post(this.f916o.f836z.f905d);
        }
    }
}

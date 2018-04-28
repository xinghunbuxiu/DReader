package com.duokan.reader.ui.general;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

class fu implements Runnable {
    /* renamed from: a */
    final /* synthetic */ float f7258a;
    /* renamed from: b */
    final /* synthetic */ AlphaAnimation f7259b;
    /* renamed from: c */
    final /* synthetic */ Transformation f7260c;
    /* renamed from: d */
    final /* synthetic */ float f7261d;
    /* renamed from: e */
    final /* synthetic */ int f7262e;
    /* renamed from: f */
    final /* synthetic */ int f7263f;
    /* renamed from: g */
    final /* synthetic */ PagesView f7264g;

    fu(PagesView pagesView, float f, AlphaAnimation alphaAnimation, Transformation transformation, float f2, int i, int i2) {
        this.f7264g = pagesView;
        this.f7258a = f;
        this.f7259b = alphaAnimation;
        this.f7260c = transformation;
        this.f7261d = f2;
        this.f7262e = i;
        this.f7263f = i2;
    }

    public void run() {
        if (this.f7264g.f6835o == this) {
            if (Float.compare(this.f7264g.getZoomFactor(), this.f7258a) == 0) {
                this.f7264g.f6835o = null;
                return;
            }
            if (!this.f7259b.hasStarted()) {
                this.f7259b.setInterpolator(new AccelerateDecelerateInterpolator());
                this.f7259b.setDuration(300);
                this.f7259b.start();
            }
            this.f7259b.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.f7260c);
            this.f7264g.m10011c(this.f7262e, this.f7263f, this.f7261d + ((this.f7258a - this.f7261d) * this.f7260c.getAlpha()));
            if (this.f7259b.hasEnded()) {
                this.f7264g.f6835o = null;
            } else {
                this.f7264g.post(this);
            }
        }
    }
}

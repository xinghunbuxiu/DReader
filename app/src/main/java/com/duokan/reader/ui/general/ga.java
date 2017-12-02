package com.duokan.reader.ui.general;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

class ga implements Runnable {
    final /* synthetic */ float a;
    final /* synthetic */ AlphaAnimation b;
    final /* synthetic */ Transformation c;
    final /* synthetic */ float d;
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ PagesView g;

    ga(PagesView pagesView, float f, AlphaAnimation alphaAnimation, Transformation transformation, float f2, int i, int i2) {
        this.g = pagesView;
        this.a = f;
        this.b = alphaAnimation;
        this.c = transformation;
        this.d = f2;
        this.e = i;
        this.f = i2;
    }

    public void run() {
        if (this.g.o == this) {
            if (Float.compare(this.g.getZoomFactor(), this.a) == 0) {
                this.g.o = null;
                return;
            }
            if (!this.b.hasStarted()) {
                this.b.setInterpolator(new AccelerateDecelerateInterpolator());
                this.b.setDuration(300);
                this.b.start();
            }
            this.b.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.c);
            this.g.c(this.e, this.f, this.d + ((this.a - this.d) * this.c.getAlpha()));
            if (this.b.hasEnded()) {
                this.g.o = null;
            } else {
                this.g.post(this);
            }
        }
    }
}

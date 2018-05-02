package com.duokan.reader.ui.reading;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

class nf implements Runnable {
    final /* synthetic */ AlphaAnimation a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ mx f;

    nf(mx mxVar, AlphaAnimation alphaAnimation, int i, int i2, int i3, int i4) {
        this.f = mxVar;
        this.a = alphaAnimation;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public void run() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Transformation transformation = new Transformation();
        this.a.getTransformation(currentAnimationTimeMillis, transformation);
        float alpha = transformation.getAlpha();
        int i = (int) (((float) this.b) + (((float) (this.c - this.b)) * alpha));
        int i2 = (int) ((alpha * ((float) (this.e - this.d))) + ((float) this.d));
        this.f.b.getPagesFrameView().scrollTo(i, 0);
        this.f.c.scrollTo(i2, 0);
        this.f.a(this.f.b.getPagesFrameView().getScrollX());
        if (!this.a.hasEnded()) {
            this.f.c.post(this);
        }
    }
}

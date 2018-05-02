package com.duokan.reader.ui.reading;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

class jk implements Runnable {
    final /* synthetic */ AlphaAnimation a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ jg d;

    jk(jg jgVar, AlphaAnimation alphaAnimation, int i, int i2) {
        this.d = jgVar;
        this.a = alphaAnimation;
        this.b = i;
        this.c = i2;
    }

    public void run() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Transformation transformation = new Transformation();
        this.a.getTransformation(currentAnimationTimeMillis, transformation);
        float f = (float) this.b;
        this.d.scrollTo((int) ((transformation.getAlpha() * ((float) (this.c - this.b))) + f), 0);
        if (!this.a.hasEnded()) {
            this.d.post(this);
        }
    }
}

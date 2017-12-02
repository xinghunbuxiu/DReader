package com.duokan.reader.ui.bookshelf;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

class cp implements Runnable {
    final /* synthetic */ AlphaAnimation a;
    final /* synthetic */ float b;
    final /* synthetic */ float c;
    final /* synthetic */ float d;
    final /* synthetic */ float e;
    final /* synthetic */ cn f;

    cp(cn cnVar, AlphaAnimation alphaAnimation, float f, float f2, float f3, float f4) {
        this.f = cnVar;
        this.a = alphaAnimation;
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = f4;
    }

    public void run() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Transformation transformation = new Transformation();
        this.a.getTransformation(currentAnimationTimeMillis, transformation);
        float alpha = transformation.getAlpha();
        this.f.a((float) ((int) (this.b + ((this.c - this.b) * alpha))), (float) ((int) ((alpha * (this.e - this.d)) + this.d)));
        if (!this.a.hasEnded()) {
            this.f.post(this);
        }
    }
}

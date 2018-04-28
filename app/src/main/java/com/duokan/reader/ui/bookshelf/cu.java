package com.duokan.reader.ui.bookshelf;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

class cu implements Runnable {
    /* renamed from: a */
    final /* synthetic */ AlphaAnimation f6305a;
    /* renamed from: b */
    final /* synthetic */ float f6306b;
    /* renamed from: c */
    final /* synthetic */ float f6307c;
    /* renamed from: d */
    final /* synthetic */ float f6308d;
    /* renamed from: e */
    final /* synthetic */ float f6309e;
    /* renamed from: f */
    final /* synthetic */ cs f6310f;

    cu(cs csVar, AlphaAnimation alphaAnimation, float f, float f2, float f3, float f4) {
        this.f6310f = csVar;
        this.f6305a = alphaAnimation;
        this.f6306b = f;
        this.f6307c = f2;
        this.f6308d = f3;
        this.f6309e = f4;
    }

    public void run() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Transformation transformation = new Transformation();
        this.f6305a.getTransformation(currentAnimationTimeMillis, transformation);
        float alpha = transformation.getAlpha();
        this.f6310f.m9418a((float) ((int) (this.f6306b + ((this.f6307c - this.f6306b) * alpha))), (float) ((int) ((alpha * (this.f6309e - this.f6308d)) + this.f6308d)));
        if (!this.f6305a.hasEnded()) {
            this.f6310f.post(this);
        }
    }
}

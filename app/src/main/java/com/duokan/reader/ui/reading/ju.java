package com.duokan.reader.ui.reading;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

class ju implements Runnable {
    /* renamed from: a */
    final /* synthetic */ AlphaAnimation f10470a;
    /* renamed from: b */
    final /* synthetic */ int f10471b;
    /* renamed from: c */
    final /* synthetic */ int f10472c;
    /* renamed from: d */
    final /* synthetic */ jq f10473d;

    ju(jq jqVar, AlphaAnimation alphaAnimation, int i, int i2) {
        this.f10473d = jqVar;
        this.f10470a = alphaAnimation;
        this.f10471b = i;
        this.f10472c = i2;
    }

    public void run() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Transformation transformation = new Transformation();
        this.f10470a.getTransformation(currentAnimationTimeMillis, transformation);
        float f = (float) this.f10471b;
        this.f10473d.scrollTo((int) ((transformation.getAlpha() * ((float) (this.f10472c - this.f10471b))) + f), 0);
        if (!this.f10470a.hasEnded()) {
            this.f10473d.post(this);
        }
    }
}

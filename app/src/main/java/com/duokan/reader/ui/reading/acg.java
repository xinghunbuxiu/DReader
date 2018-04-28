package com.duokan.reader.ui.reading;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class acg implements AnimatorUpdateListener {
    /* renamed from: a */
    final /* synthetic */ acf f9450a;

    acg(acf acf) {
        this.f9450a = acf;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9450a.f9442f.mo2126c(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.f9450a.invalidate();
    }
}

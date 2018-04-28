package com.duokan.reader.ui.reading;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class aci implements AnimatorUpdateListener {
    /* renamed from: a */
    final /* synthetic */ acf f9453a;

    aci(acf acf) {
        this.f9453a = acf;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9453a.f9442f.mo2126c(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.f9453a.invalidate();
    }
}

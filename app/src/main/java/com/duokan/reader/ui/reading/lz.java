package com.duokan.reader.ui.reading;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class lz implements AnimatorUpdateListener {
    /* renamed from: a */
    final /* synthetic */ ly f10604a;

    lz(ly lyVar) {
        this.f10604a = lyVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f10604a.f10601b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f10604a.f10600a.f10250b.mo2126c(1.0f - this.f10604a.f10601b);
        this.f10604a.invalidate();
    }
}

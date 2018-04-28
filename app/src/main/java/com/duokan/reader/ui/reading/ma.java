package com.duokan.reader.ui.reading;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ma implements AnimatorUpdateListener {
    /* renamed from: a */
    final /* synthetic */ ly f10606a;

    ma(ly lyVar) {
        this.f10606a = lyVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f10606a.f10601b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f10606a.f10600a.f10250b.mo2126c(1.0f - this.f10606a.f10601b);
        this.f10606a.invalidate();
    }
}

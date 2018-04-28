package com.duokan.reader.ui.reading;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class acm implements AnimatorUpdateListener {
    /* renamed from: a */
    final /* synthetic */ acf f9459a;

    acm(acf acf) {
        this.f9459a = acf;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9459a.invalidate();
    }
}

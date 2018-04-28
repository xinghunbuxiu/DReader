package com.duokan.reader.ui.reading;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ack implements AnimatorUpdateListener {
    /* renamed from: a */
    final /* synthetic */ acf f9456a;

    ack(acf acf) {
        this.f9456a = acf;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9456a.invalidate();
    }
}

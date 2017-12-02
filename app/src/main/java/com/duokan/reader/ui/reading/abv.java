package com.duokan.reader.ui.reading;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class abv implements AnimatorUpdateListener {
    final /* synthetic */ abs a;

    abv(abs com_duokan_reader_ui_reading_abs) {
        this.a = com_duokan_reader_ui_reading_abs;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.f.c(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.a.invalidate();
    }
}

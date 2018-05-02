package com.duokan.reader.ui.reading;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class abz implements AnimatorUpdateListener {
    final /* synthetic */ abs a;

    abz(abs com_duokan_reader_ui_reading_abs) {
        this.a = com_duokan_reader_ui_reading_abs;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.invalidate();
    }
}

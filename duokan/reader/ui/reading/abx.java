package com.duokan.reader.ui.reading;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class abx implements AnimatorUpdateListener {
    final /* synthetic */ abs a;

    abx(abs com_duokan_reader_ui_reading_abs) {
        this.a = com_duokan_reader_ui_reading_abs;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.invalidate();
    }
}

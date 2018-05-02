package com.duokan.reader.ui.reading;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class abu implements AnimatorListener {
    final /* synthetic */ Runnable a;
    final /* synthetic */ abs b;

    abu(abs com_duokan_reader_ui_reading_abs, Runnable runnable) {
        this.b = com_duokan_reader_ui_reading_abs;
        this.a = runnable;
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.b.post(this.a);
    }

    public void onAnimationCancel(Animator animator) {
        this.b.post(this.a);
    }

    public void onAnimationRepeat(Animator animator) {
    }
}

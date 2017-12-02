package com.duokan.reader.ui.reading;

import android.graphics.drawable.ColorDrawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class qs implements AnimationListener {
    final /* synthetic */ qh a;

    qs(qh qhVar) {
        this.a = qhVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.a.e.getPagesFrameView().setForeground(new ColorDrawable(-16777216));
    }
}

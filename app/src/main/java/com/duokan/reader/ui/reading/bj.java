package com.duokan.reader.ui.reading;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bj implements AnimationListener {
    final /* synthetic */ bh a;

    bj(bh bhVar) {
        this.a = bhVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.a.q.post(this.a.r);
    }
}

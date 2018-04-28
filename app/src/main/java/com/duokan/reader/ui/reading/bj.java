package com.duokan.reader.ui.reading;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bj implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ bh f9854a;

    bj(bh bhVar) {
        this.f9854a = bhVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.f9854a.f9850q.post(this.f9854a.f9851r);
    }
}

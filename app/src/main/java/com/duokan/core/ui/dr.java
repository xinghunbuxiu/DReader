package com.duokan.core.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class dr implements AnimationListener {
    final /* synthetic */ di a;
    final /* synthetic */ dq b;

    dr(dq dqVar, di diVar) {
        this.b = dqVar;
        this.a = diVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (this.b.h) {
            if (this.b.g != null) {
                this.b.b.post(this.b.g);
            }
        } else if (this.b.f != null) {
            this.b.b.post(this.b.f);
        }
    }
}

package com.duokan.core.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.duokan.core.sys.t;

final class eg implements AnimationListener {
    final /* synthetic */ Runnable a;

    eg(Runnable runnable) {
        this.a = runnable;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        t.b(this.a);
    }
}

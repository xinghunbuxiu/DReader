package com.duokan.core.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.duokan.core.sys.TaskHandler;

class n implements AnimationListener {
    final /* synthetic */ ExtendView a;

    n(ExtendView extendView) {
        this.a = extendView;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        TaskHandler.PostTask(new o(this));
    }
}

package com.duokan.reader.ui.welcome;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class f implements AnimationListener {
    final /* synthetic */ Runnable a;
    final /* synthetic */ a b;

    f(a aVar, Runnable runnable) {
        this.b = aVar;
        this.a = runnable;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (this.a != null) {
            this.b.post(this.a);
        }
    }
}

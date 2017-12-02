package com.duokan.reader.ui.bookshelf;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class co implements AnimationListener {
    final /* synthetic */ Runnable a;
    final /* synthetic */ cn b;

    co(cn cnVar, Runnable runnable) {
        this.b = cnVar;
        this.a = runnable;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.a.run();
    }

    public void onAnimationRepeat(Animation animation) {
    }
}

package com.duokan.reader.ui.bookshelf;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class cl implements AnimationListener {
    final /* synthetic */ bz c;

    private cl(bz bzVar) {
        this.c = bzVar;
    }

    public void onAnimationStart(Animation animation) {
        this.c.q = true;
    }

    public void onAnimationEnd(Animation animation) {
        this.c.q = false;
    }

    public void onAnimationRepeat(Animation animation) {
    }
}

package com.duokan.reader.ui.bookshelf;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ao implements AnimationListener {
    final /* synthetic */ ai a;

    ao(ai aiVar) {
        this.a = aiVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.a.p = true;
    }

    public void onAnimationRepeat(Animation animation) {
    }
}

package com.duokan.reader.ui.bookshelf;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ap implements AnimationListener {
    final /* synthetic */ ai a;

    ap(ai aiVar) {
        this.a = aiVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.a.p = false;
        this.a.requestDetach();
    }

    public void onAnimationRepeat(Animation animation) {
    }
}

package com.duokan.reader.ui.bookshelf;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class dc implements AnimationListener {
    final /* synthetic */ cz a;

    dc(cz czVar) {
        this.a = czVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.a.C = null;
    }
}

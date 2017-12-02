package com.duokan.reader.ui.bookshelf;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class iq implements AnimationListener {
    final /* synthetic */ il a;

    iq(il ilVar) {
        this.a = ilVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.a.requestDetach();
    }

    public void onAnimationRepeat(Animation animation) {
    }
}

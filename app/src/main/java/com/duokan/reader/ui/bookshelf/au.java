package com.duokan.reader.ui.bookshelf;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class au implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ ao f6145a;

    au(ao aoVar) {
        this.f6145a = aoVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.f6145a.f6136p = true;
    }

    public void onAnimationRepeat(Animation animation) {
    }
}

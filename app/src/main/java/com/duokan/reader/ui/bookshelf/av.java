package com.duokan.reader.ui.bookshelf;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class av implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ ao f6146a;

    av(ao aoVar) {
        this.f6146a = aoVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.f6146a.f6136p = false;
        this.f6146a.requestDetach();
    }

    public void onAnimationRepeat(Animation animation) {
    }
}

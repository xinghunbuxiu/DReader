package com.duokan.reader.ui.bookshelf;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class cq implements AnimationListener {
    /* renamed from: c */
    final /* synthetic */ ce f6277c;

    private cq(ce ceVar) {
        this.f6277c = ceVar;
    }

    public void onAnimationStart(Animation animation) {
        this.f6277c.f6265q = true;
    }

    public void onAnimationEnd(Animation animation) {
        this.f6277c.f6265q = false;
    }

    public void onAnimationRepeat(Animation animation) {
    }
}

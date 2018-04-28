package com.duokan.reader.ui.bookshelf;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ct implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ Runnable f6303a;
    /* renamed from: b */
    final /* synthetic */ cs f6304b;

    ct(cs csVar, Runnable runnable) {
        this.f6304b = csVar;
        this.f6303a = runnable;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.f6303a.run();
    }

    public void onAnimationRepeat(Animation animation) {
    }
}

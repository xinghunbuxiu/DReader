package com.duokan.reader.ui.general;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.duokan.core.sys.t;

class fr implements AnimationListener {
    final /* synthetic */ Runnable a;
    final /* synthetic */ PagesController b;

    fr(PagesController pagesController, Runnable runnable) {
        this.b = pagesController;
        this.a = runnable;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        t.b(this.a);
    }
}

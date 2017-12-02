package com.duokan.reader.ui.general.web;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.duokan.core.sys.t;

class bz implements AnimationListener {
    final /* synthetic */ AlphaAnimation a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ by c;

    bz(by byVar, AlphaAnimation alphaAnimation, Runnable runnable) {
        this.c = byVar;
        this.a = alphaAnimation;
        this.b = runnable;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        t.b(new ca(this));
    }

    public void onAnimationRepeat(Animation animation) {
    }
}

package com.duokan.reader.ui.general.web;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.duokan.core.sys.UThread;

class by implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ AlphaAnimation f7653a;
    /* renamed from: b */
    final /* synthetic */ Runnable f7654b;
    /* renamed from: c */
    final /* synthetic */ bx f7655c;

    by(bx bxVar, AlphaAnimation alphaAnimation, Runnable runnable) {
        this.f7655c = bxVar;
        this.f7653a = alphaAnimation;
        this.f7654b = runnable;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        UThread.post(new bz(this));
    }

    public void onAnimationRepeat(Animation animation) {
    }
}

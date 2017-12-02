package com.duokan.reader.ui.reading;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.duokan.core.sys.t;

class jj implements AnimationListener {
    final /* synthetic */ Runnable a;
    final /* synthetic */ jg b;

    jj(jg jgVar, Runnable runnable) {
        this.b = jgVar;
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

package com.duokan.reader.ui.general.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.duokan.core.sys.t;

final class d implements AnimationListener {
    final /* synthetic */ Runnable a;

    d(Runnable runnable) {
        this.a = runnable;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        t.a(this.a);
    }
}

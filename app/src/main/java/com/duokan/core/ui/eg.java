package com.duokan.core.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.duokan.core.sys.UThread;

final class eg implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ Runnable f1217a;

    eg(Runnable runnable) {
        this.f1217a = runnable;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        UThread.post(this.f1217a);
    }
}

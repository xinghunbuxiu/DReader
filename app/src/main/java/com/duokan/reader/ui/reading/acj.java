package com.duokan.reader.ui.reading;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class acj implements AnimatorListener {
    /* renamed from: a */
    final /* synthetic */ Runnable f9454a;
    /* renamed from: b */
    final /* synthetic */ acf f9455b;

    acj(acf acf, Runnable runnable) {
        this.f9455b = acf;
        this.f9454a = runnable;
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.f9455b.f9439c = null;
        this.f9455b.post(this.f9454a);
    }

    public void onAnimationCancel(Animator animator) {
        this.f9455b.f9439c = null;
        this.f9455b.post(this.f9454a);
    }

    public void onAnimationRepeat(Animator animator) {
    }
}

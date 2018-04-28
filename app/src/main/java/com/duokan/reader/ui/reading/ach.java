package com.duokan.reader.ui.reading;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ach implements AnimatorListener {
    /* renamed from: a */
    final /* synthetic */ Runnable f9451a;
    /* renamed from: b */
    final /* synthetic */ acf f9452b;

    ach(acf acf, Runnable runnable) {
        this.f9452b = acf;
        this.f9451a = runnable;
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.f9452b.post(this.f9451a);
    }

    public void onAnimationCancel(Animator animator) {
        this.f9452b.post(this.f9451a);
    }

    public void onAnimationRepeat(Animator animator) {
    }
}

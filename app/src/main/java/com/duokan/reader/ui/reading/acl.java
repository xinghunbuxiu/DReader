package com.duokan.reader.ui.reading;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class acl implements AnimatorListener {
    /* renamed from: a */
    final /* synthetic */ Runnable f9457a;
    /* renamed from: b */
    final /* synthetic */ acf f9458b;

    acl(acf acf, Runnable runnable) {
        this.f9458b = acf;
        this.f9457a = runnable;
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.f9458b.post(this.f9457a);
    }

    public void onAnimationCancel(Animator animator) {
        this.f9458b.post(this.f9457a);
    }

    public void onAnimationRepeat(Animator animator) {
    }
}

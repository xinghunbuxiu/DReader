package com.duokan.reader.ui.general;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class fq implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ boolean f7250a;
    /* renamed from: b */
    final /* synthetic */ fm f7251b;

    fq(fm fmVar, boolean z) {
        this.f7251b = fmVar;
        this.f7250a = z;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.f7251b.f7246h = false;
        if (this.f7250a) {
            this.f7251b.f7240a.f6189g = true;
            this.f7251b.f7240a.mo1641a();
        }
    }
}

package com.duokan.reader.ui.general;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class fw implements AnimationListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ fs b;

    fw(fs fsVar, boolean z) {
        this.b = fsVar;
        this.a = z;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.b.h = false;
        if (this.a) {
            this.b.a.g = true;
            this.b.a.a();
        }
    }
}

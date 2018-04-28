package com.duokan.core.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class dr implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ di f1170a;
    /* renamed from: b */
    final /* synthetic */ dq f1171b;

    dr(dq dqVar, di diVar) {
        this.f1171b = dqVar;
        this.f1170a = diVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f1171b.f1156h) {
            if (this.f1171b.f1155g != null) {
                this.f1171b.f1150b.post(this.f1171b.f1155g);
            }
        } else if (this.f1171b.f1154f != null) {
            this.f1171b.f1150b.post(this.f1171b.f1154f);
        }
    }
}

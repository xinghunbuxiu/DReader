package com.duokan.core.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.duokan.core.sys.t;

class bn implements AnimationListener {
    final /* synthetic */ bk a;

    bn(bk bkVar) {
        this.a = bkVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        t.b(new bo(this));
    }
}

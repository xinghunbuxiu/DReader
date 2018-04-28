package com.duokan.core.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.duokan.core.sys.UThread;

class bn implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ bk f1026a;

    bn(bk bkVar) {
        this.f1026a = bkVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        UThread.post(new bo(this));
    }
}

package com.duokan.core.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

class co implements AnimationListener {
    final /* synthetic */ FrameLayout a;
    final /* synthetic */ boolean b;
    final /* synthetic */ TabBarView c;

    co(TabBarView tabBarView, FrameLayout frameLayout, boolean z) {
        this.c = tabBarView;
        this.a = frameLayout;
        this.b = z;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (this.a != null) {
            this.a.setSelected(true);
            this.a.getChildAt(0).setSelected(true);
        }
        this.c.post(new cp(this));
    }
}

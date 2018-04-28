package com.duokan.core.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

class co implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ FrameLayout f1086a;
    /* renamed from: b */
    final /* synthetic */ boolean f1087b;
    /* renamed from: c */
    final /* synthetic */ TabBarView f1088c;

    co(TabBarView tabBarView, FrameLayout frameLayout, boolean z) {
        this.f1088c = tabBarView;
        this.f1086a = frameLayout;
        this.f1087b = z;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f1086a != null) {
            this.f1086a.setSelected(true);
            this.f1086a.getChildAt(0).setSelected(true);
        }
        this.f1088c.post(new cp(this));
    }
}

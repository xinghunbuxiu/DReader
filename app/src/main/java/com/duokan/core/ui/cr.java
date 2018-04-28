package com.duokan.core.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;

class cr implements OnTouchListener {
    /* renamed from: a */
    final /* synthetic */ TabBarView f1091a;

    cr(TabBarView tabBarView) {
        this.f1091a = tabBarView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.f1091a.m1321b(this.f1091a.m1304a((FrameLayout) view)).setPressed(true);
        } else if (motionEvent.getActionMasked() == 1) {
            this.f1091a.m1321b(this.f1091a.m1304a((FrameLayout) view)).setPressed(false);
        }
        return false;
    }
}

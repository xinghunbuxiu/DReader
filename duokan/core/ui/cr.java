package com.duokan.core.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;

class cr implements OnTouchListener {
    final /* synthetic */ TabBarView a;

    cr(TabBarView tabBarView) {
        this.a = tabBarView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.a.b(this.a.a((FrameLayout) view)).setPressed(true);
        } else if (motionEvent.getActionMasked() == 1) {
            this.a.b(this.a.a((FrameLayout) view)).setPressed(false);
        }
        return false;
    }
}

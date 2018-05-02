package com.duokan.core.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

class ad extends FrameLayout {
    final /* synthetic */ HatGridView a;

    ad(HatGridView hatGridView, Context context) {
        this.a = hatGridView;
        super(context);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = UTools.resetMotionEvent(motionEvent, (View) this, this.a.a);
        boolean onInterceptTouchEvent = this.a.a.onInterceptTouchEvent(a);
        a.recycle();
        return onInterceptTouchEvent;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = UTools.resetMotionEvent(motionEvent, (View) this, this.a.a);
        boolean onTouchEvent = this.a.a.onTouchEvent(a);
        a.recycle();
        return onTouchEvent;
    }
}

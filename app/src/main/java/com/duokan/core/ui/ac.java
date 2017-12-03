package com.duokan.core.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

class ac extends FrameLayout {
    HatGridView hatGridView;

    ac(HatGridView hatGridView, Context context) {
        this.hatGridView = hatGridView;
        super(context);
    }

    public ac(@NonNull Context context) {
        super(context);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = UTools.resetMotionEvent(motionEvent, (View) this, this.hatGridView.a);
        boolean onInterceptTouchEvent = this.hatGridView.a.onInterceptTouchEvent(a);
        a.recycle();
        return onInterceptTouchEvent;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = UTools.resetMotionEvent(motionEvent, (View) this, this.hatGridView.a);
        boolean onTouchEvent = this.hatGridView.a.onTouchEvent(a);
        a.recycle();
        return onTouchEvent;
    }
}

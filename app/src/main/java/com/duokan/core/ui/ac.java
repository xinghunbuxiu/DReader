package com.duokan.core.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

class ac extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ HatGridView f894a;

    ac(HatGridView hatGridView, Context context) {
        this.f894a = hatGridView;
        super(context);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = AnimUtils.m1908a(motionEvent, (View) this, this.f894a.f811a);
        boolean onInterceptTouchEvent = this.f894a.f811a.onInterceptTouchEvent(a);
        a.recycle();
        return onInterceptTouchEvent;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = AnimUtils.m1908a(motionEvent, (View) this, this.f894a.f811a);
        boolean onTouchEvent = this.f894a.f811a.onTouchEvent(a);
        a.recycle();
        return onTouchEvent;
    }
}

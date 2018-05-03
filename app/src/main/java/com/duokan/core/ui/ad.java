package com.duokan.core.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

class ad extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ HatGridView f895a;

    ad(HatGridView hatGridView, Context context) {
        this.f895a = hatGridView;
        super(context);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = AnimUtils.m1908a(motionEvent, (View) this, this.f895a.f811a);
        boolean onInterceptTouchEvent = this.f895a.f811a.onInterceptTouchEvent(a);
        a.recycle();
        return onInterceptTouchEvent;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = AnimUtils.m1908a(motionEvent, (View) this, this.f895a.f811a);
        boolean onTouchEvent = this.f895a.f811a.onTouchEvent(a);
        a.recycle();
        return onTouchEvent;
    }
}

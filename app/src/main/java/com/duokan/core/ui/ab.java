package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

class ab extends LinearLayout {
    /* renamed from: a */
    final /* synthetic */ HatGridView f893a;

    ab(HatGridView hatGridView, Context context) {
        this.f893a = hatGridView;
        super(context);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = dv.m1908a(motionEvent, (View) this, this.f893a.f811a);
        boolean onInterceptTouchEvent = this.f893a.f811a.onInterceptTouchEvent(a);
        a.recycle();
        return onInterceptTouchEvent;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = dv.m1908a(motionEvent, (View) this, this.f893a.f811a);
        boolean onTouchEvent = this.f893a.f811a.onTouchEvent(a);
        a.recycle();
        return onTouchEvent;
    }

    public final void dispatchDraw(Canvas canvas) {
        canvas.clipRect(0, this.f893a.m1231u() - this.f893a.f815e.getTop(), getWidth(), getHeight());
        super.dispatchDraw(canvas);
    }
}

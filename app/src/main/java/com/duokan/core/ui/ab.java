package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

class ab extends LinearLayout {
    final /* synthetic */ HatGridView a;

    ab(HatGridView hatGridView, Context context) {
        this.a = hatGridView;
        super(context);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = dv.a(motionEvent, (View) this, this.a.a);
        boolean onInterceptTouchEvent = this.a.a.onInterceptTouchEvent(a);
        a.recycle();
        return onInterceptTouchEvent;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = dv.a(motionEvent, (View) this, this.a.a);
        boolean onTouchEvent = this.a.a.onTouchEvent(a);
        a.recycle();
        return onTouchEvent;
    }

    public final void dispatchDraw(Canvas canvas) {
        canvas.clipRect(0, this.a.u() - this.a.e.getTop(), getWidth(), getHeight());
        super.dispatchDraw(canvas);
    }
}

package com.duokan.reader.ui.surfing;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

class g extends FrameLayout {
    final /* synthetic */ f a;

    g(f fVar, Context context) {
        this.a = fVar;
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getY() > ((float) (getHeight() - this.a.r.getHeight()))) {
            return false;
        }
        return this.a.m.a((View) this, motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.a.m.onTouch(this, motionEvent);
    }
}

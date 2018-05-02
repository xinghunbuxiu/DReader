package com.duokan.reader.ui.surfing;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/* renamed from: com.duokan.reader.ui.surfing.j */
class C1523j extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ C1522i f11559a;

    C1523j(C1522i c1522i, Context context) {
        this.f11559a = c1522i;
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getY() > ((float) (getHeight() - this.f11559a.f11553u.getHeight()))) {
            return false;
        }
        return this.f11559a.f11548p.m2044a((View) this, motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f11559a.f11548p.onTouch(this, motionEvent);
    }
}

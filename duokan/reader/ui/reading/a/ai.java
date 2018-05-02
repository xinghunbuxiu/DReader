package com.duokan.reader.ui.reading.a;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class ai implements du {
    final /* synthetic */ MotionEvent a;
    final /* synthetic */ ag b;

    ai(ag agVar, MotionEvent motionEvent) {
        this.b = agVar;
        this.a = motionEvent;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (this.a.getPointerCount() > 1 && !this.b.f && ((this.b.a.e() && Float.compare(pointF2.x, 0.0f) < 0) || (!this.b.a.e() && Float.compare(pointF2.x, 0.0f) > 0))) {
            this.b.f = true;
            this.b.c(true);
            this.b.d(true);
            this.b.a.f();
        } else if (this.b.f) {
            this.b.a.a(pointF2.x, pointF2.y);
        }
    }
}

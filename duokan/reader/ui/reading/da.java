package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class da implements du {
    final /* synthetic */ MotionEvent a;
    final /* synthetic */ cy b;

    da(cy cyVar, MotionEvent motionEvent) {
        this.b = cyVar;
        this.a = motionEvent;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (Float.compare(this.b.a.d.getFrameScale(), 1.0f) > 0) {
            if (this.b.j) {
                this.b.a.d.a((int) pointF2.x, (int) pointF2.y, false);
            } else if (this.a.getPointerCount() < 2) {
                this.b.j = true;
                this.b.c(true);
            }
        }
    }
}

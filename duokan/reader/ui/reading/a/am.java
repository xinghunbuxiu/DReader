package com.duokan.reader.ui.reading.a;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class am implements du {
    final /* synthetic */ MotionEvent a;
    final /* synthetic */ an b;
    final /* synthetic */ al c;

    am(al alVar, MotionEvent motionEvent, an anVar) {
        this.c = alVar;
        this.a = motionEvent;
        this.b = anVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (Float.compare(pointF2.y, 0.0f) < 0 && this.a.getPointerCount() < 2) {
            this.b.a();
            this.c.b(false);
            this.c.c(true);
        }
    }
}

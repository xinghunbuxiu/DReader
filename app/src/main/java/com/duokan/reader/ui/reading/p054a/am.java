package com.duokan.reader.ui.reading.p054a;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

/* renamed from: com.duokan.reader.ui.reading.a.am */
class am implements du {
    /* renamed from: a */
    final /* synthetic */ MotionEvent f9201a;
    /* renamed from: b */
    final /* synthetic */ an f9202b;
    /* renamed from: c */
    final /* synthetic */ al f9203c;

    am(al alVar, MotionEvent motionEvent, an anVar) {
        this.f9203c = alVar;
        this.f9201a = motionEvent;
        this.f9202b = anVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (Float.compare(pointF2.y, 0.0f) < 0 && this.f9201a.getPointerCount() < 2) {
            this.f9202b.mo2487a();
            this.f9203c.m1613b(false);
            this.f9203c.m1617c(true);
        }
    }
}

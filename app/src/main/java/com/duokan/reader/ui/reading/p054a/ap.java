package com.duokan.reader.ui.reading.p054a;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.cu;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

/* renamed from: com.duokan.reader.ui.reading.a.ap */
class ap implements cu {
    /* renamed from: a */
    final /* synthetic */ es f9206a;
    /* renamed from: b */
    final /* synthetic */ MotionEvent f9207b;
    /* renamed from: c */
    final /* synthetic */ ao f9208c;

    ap(ao aoVar, es esVar, MotionEvent motionEvent) {
        this.f9208c = aoVar;
        this.f9206a = esVar;
        this.f9207b = motionEvent;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        this.f9208c.m1620d(this.f9208c.m12656a(view, this.f9206a, this.f9207b));
    }
}

package com.duokan.reader.ui.reading.a;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.onTapListener;
import com.duokan.core.ui.er;
import com.duokan.core.ui.OnTouchChangeListener;

class ap implements onTapListener {
    final /* synthetic */ OnTouchChangeListener a;
    final /* synthetic */ MotionEvent b;
    final /* synthetic */ ao c;

    ap(ao aoVar, OnTouchChangeListener esVar, MotionEvent motionEvent) {
        this.c = aoVar;
        this.a = esVar;
        this.b = motionEvent;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        this.c.d(this.c.a(view, this.a, this.b));
    }
}

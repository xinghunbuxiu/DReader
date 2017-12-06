package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.View;

class fd implements bw, cu {
    final ev a;

    private fd(ev evVar) {
        this.a = evVar;
    }

    public void onTouchDown(View view, PointF pointF) {
        this.a.a(pointF);
    }

    public void onTouchUp(View view, PointF pointF) {
        this.a.b(pointF);
    }

    public void onTouchCancel(View view, PointF pointF) {
        this.a.c(pointF);
    }

    public void a(View view, PointF pointF) {
        this.a.e(pointF);
    }

    public void onTap(er erVar, View view, PointF pointF) {
        this.a.d(pointF);
    }
}

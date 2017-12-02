package com.duokan.reader.ui.general;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.ce;
import com.duokan.core.ui.er;

class gl implements ce {
    final /* synthetic */ gk a;

    gl(gk gkVar) {
        this.a = gkVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, float f) {
        this.a.a.a((int) pointF.x, (int) pointF.y, Math.max(0.5f, Math.min(this.a.a.getZoomFactor() * f, 4.5f)));
        this.a.e = pointF;
        this.a.c(true);
    }
}

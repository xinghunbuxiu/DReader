package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.ce;
import com.duokan.core.ui.er;

class lm implements ce {
    final /* synthetic */ float[] a;
    final /* synthetic */ PointF b;
    final /* synthetic */ lj c;

    lm(lj ljVar, float[] fArr, PointF pointF) {
        this.c = ljVar;
        this.a = fArr;
        this.b = pointF;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, float f) {
        this.a[0] = f;
        this.b.x = pointF.x;
        this.b.y = pointF.y;
    }
}

package com.duokan.reader.ui.general;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class fv implements du {
    final /* synthetic */ fs a;

    fv(fs fsVar) {
        this.a = fsVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        this.a.f = this.a.f + pointF2.x;
        if (pointF2.x > 0.0f) {
            this.a.g = true;
            this.a.c(true);
        }
    }
}

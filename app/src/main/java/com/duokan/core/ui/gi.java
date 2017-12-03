package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.Scrollable.OverScrollMode;

class gi implements ce {
    final /* synthetic */ View a;
    final /* synthetic */ gh b;

    gi(gh ghVar, View view) {
        this.b = ghVar;
        this.a = view;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, float f) {
        if (!this.b.g) {
            this.b.a.b.a(OverScrollMode.NEVER);
            this.b.a.b.b(OverScrollMode.NEVER);
            this.b.f.set(pointF.x + ((float) this.b.a.getScrollX()), pointF.y + ((float) this.b.a.getScrollY()));
            UTools.addAnimation(this.b.f, this.b.a, this.a);
            this.b.g = true;
            this.b.j = this.b.a.getZoomAngle();
            this.b.c(true);
        }
        this.b.i = this.b.a.getZoomFactor() * f;
        this.b.i = Math.max(this.b.a.getMinZoomFactor() - (this.b.a.getMinZoomFactor() * 0.5f), Math.min(this.b.i, this.b.a.getMaxZoomFactor() + (this.b.a.getMaxZoomFactor() * 0.5f)));
        this.b.h.set(pointF);
    }
}

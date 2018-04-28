package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.bw;

class adf implements bw {
    /* renamed from: a */
    final /* synthetic */ MotionEvent f9511a;
    /* renamed from: b */
    final /* synthetic */ ade f9512b;

    adf(ade ade, MotionEvent motionEvent) {
        this.f9512b = ade;
        this.f9511a = motionEvent;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo521a(View view, PointF pointF) {
        this.f9512b.m1617c(this.f9512b.f9507a.m12559a((int) pointF.x, (int) pointF.y, this.f9511a.getAction(), view));
    }
}

package com.duokan.reader.ui.general;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.ce;
import com.duokan.core.ui.er;

class gf implements ce {
    /* renamed from: a */
    final /* synthetic */ ge f7272a;

    gf(ge geVar) {
        this.f7272a = geVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo537a(er erVar, View view, PointF pointF, float f) {
        this.f7272a.f7268a.m9989a((int) pointF.x, (int) pointF.y, Math.max(0.5f, Math.min(this.f7272a.f7268a.getZoomFactor() * f, 4.5f)));
        this.f7272a.f7271e = pointF;
        this.f7272a.m1617c(true);
    }
}

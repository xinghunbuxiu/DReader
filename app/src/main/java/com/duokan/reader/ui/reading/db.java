package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.ce;
import com.duokan.core.ui.er;

class db implements ce {
    /* renamed from: a */
    final /* synthetic */ da f9984a;

    db(da daVar) {
        this.f9984a = daVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo537a(er erVar, View view, PointF pointF, float f) {
        this.f9984a.f9982i = true;
        this.f9984a.f9975a.f9952d.m13307a(new Point((int) pointF.x, (int) pointF.y), f);
        this.f9984a.m1617c(true);
        this.f9984a.m1620d(true);
    }
}

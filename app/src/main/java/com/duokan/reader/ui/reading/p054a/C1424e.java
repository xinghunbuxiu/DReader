package com.duokan.reader.ui.reading.p054a;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

/* renamed from: com.duokan.reader.ui.reading.a.e */
class C1424e implements du {
    /* renamed from: a */
    final /* synthetic */ C1422c f9216a;

    C1424e(C1422c c1422c) {
        this.f9216a = c1422c;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (!this.f9216a.f9214e && (this.f9216a.f9211a.mo2400a() || !this.f9216a.f9211a.mo2400a())) {
            this.f9216a.f9214e = true;
            this.f9216a.m1617c(true);
            this.f9216a.m1620d(true);
            this.f9216a.f9211a.mo2401b();
        } else if (this.f9216a.f9214e) {
            this.f9216a.f9211a.mo2397a(pointF2.x, pointF2.y);
        }
    }
}

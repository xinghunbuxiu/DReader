package com.duokan.reader.ui.reading.p054a;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.C0382r;
import com.duokan.core.ui.er;

/* renamed from: com.duokan.reader.ui.reading.a.d */
class C1423d implements C0382r {
    /* renamed from: a */
    final /* synthetic */ C1422c f9215a;

    C1423d(C1422c c1422c) {
        this.f9215a = c1422c;
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo528a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (this.f9215a.f9214e) {
            this.f9215a.f9211a.mo2398a(pointF2);
            this.f9215a.f9214e = false;
            this.f9215a.m1620d(true);
        }
    }
}

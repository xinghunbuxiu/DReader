package com.duokan.reader.ui.reading.p054a;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.cu;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

/* renamed from: com.duokan.reader.ui.reading.a.b */
class C1421b implements cu {
    /* renamed from: a */
    final /* synthetic */ es f9209a;
    /* renamed from: b */
    final /* synthetic */ C1420a f9210b;

    C1421b(C1420a c1420a, es esVar) {
        this.f9210b = c1420a;
        this.f9209a = esVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        this.f9210b.m1620d(this.f9210b.m12617a(view, this.f9209a, pointF));
    }
}

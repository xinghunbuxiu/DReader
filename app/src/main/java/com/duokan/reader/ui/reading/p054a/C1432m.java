package com.duokan.reader.ui.reading.p054a;

import android.graphics.Point;
import android.graphics.PointF;
import android.util.Pair;
import android.view.View;
import com.duokan.core.ui.cu;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.er;

/* renamed from: com.duokan.reader.ui.reading.a.m */
class C1432m implements cu {
    /* renamed from: a */
    final /* synthetic */ C1433n f9227a;
    /* renamed from: b */
    final /* synthetic */ C1431l f9228b;

    C1432m(C1431l c1431l, C1433n c1433n) {
        this.f9228b = c1431l;
        this.f9227a = c1433n;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        Pair a = this.f9228b.f9225a.mo2013a(new Point((int) pointF.x, (int) pointF.y), AnimUtils.m1932b(view.getContext(), 20.0f));
        if (a != null) {
            this.f9227a.mo2489a(a);
            this.f9228b.m1620d(true);
        }
    }
}

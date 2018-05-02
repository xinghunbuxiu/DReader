package com.duokan.reader.ui.reading.p054a;

import android.graphics.Point;
import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.cu;
import com.duokan.core.ui.er;
import com.duokan.reader.domain.document.ae;

/* renamed from: com.duokan.reader.ui.reading.a.p */
class C1435p implements cu {
    /* renamed from: a */
    final /* synthetic */ C1436q f9231a;
    /* renamed from: b */
    final /* synthetic */ C1434o f9232b;

    C1435p(C1434o c1434o, C1436q c1436q) {
        this.f9232b = c1434o;
        this.f9231a = c1436q;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        ae a = this.f9232b.m12712a(new Point(Math.round(pointF.x), Math.round(pointF.y)));
        if (a != null) {
            this.f9231a.mo2493a(this.f9232b, view, a);
            this.f9232b.m1620d(true);
        }
    }
}

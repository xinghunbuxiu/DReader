package com.duokan.reader.ui.reading.p054a;

import android.graphics.Point;
import android.graphics.PointF;
import android.util.Pair;
import android.view.View;
import com.duokan.core.ui.cu;
import com.duokan.core.ui.er;
import com.duokan.reader.ui.reading.gx;

/* renamed from: com.duokan.reader.ui.reading.a.ab */
class ab implements cu {
    /* renamed from: a */
    final /* synthetic */ ac f9183a;
    /* renamed from: b */
    final /* synthetic */ aa f9184b;

    ab(aa aaVar, ac acVar) {
        this.f9184b = aaVar;
        this.f9183a = acVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        Pair b = this.f9184b.f9181a.mo2094b(new Point(Math.round(pointF.x), Math.round(pointF.y)));
        if (b != null) {
            this.f9183a.mo2490a(b, ((gx) b.first).getPageDrawable().mo1328j(((Integer) b.second).intValue()));
            this.f9184b.m1620d(true);
        }
    }
}

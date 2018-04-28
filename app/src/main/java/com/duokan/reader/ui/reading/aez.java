package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.cu;
import com.duokan.core.ui.er;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.bb;

class aez implements cu {
    /* renamed from: a */
    final /* synthetic */ aey f9610a;

    aez(aey aey) {
        this.f9610a = aey;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        bb b = this.f9610a.f9608a.f9541a.mo2096b((int) pointF.x, (int) pointF.y);
        if (!b.m5817f()) {
            this.f9610a.f9608a.m13429c((C0897d) b.mo1198g());
        }
        this.f9610a.m1620d(true);
    }
}

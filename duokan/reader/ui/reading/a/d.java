package com.duokan.reader.ui.reading.a;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.er;
import com.duokan.core.ui.r;

class d implements r {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (this.a.e) {
            this.a.a.a(pointF2);
            this.a.e = false;
            this.a.d(true);
        }
    }
}

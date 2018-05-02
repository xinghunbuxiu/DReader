package com.duokan.reader.ui.reading.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.onTapListener;
import com.duokan.core.ui.er;
import com.duokan.reader.domain.document.ae;

class p implements onTapListener {
    final /* synthetic */ q a;
    final /* synthetic */ o b;

    p(o oVar, q qVar) {
        this.b = oVar;
        this.a = qVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        ae a = this.b.a(new Point(Math.round(pointF.x), Math.round(pointF.y)));
        if (a != null) {
            this.a.a(this.b, view, a);
            this.b.d(true);
        }
    }
}

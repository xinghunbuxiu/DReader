package com.duokan.reader.ui.reading.a;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.ui.er;
import com.duokan.core.ui.i;

class ae implements i {
    final /* synthetic */ af a;
    final /* synthetic */ ad b;

    ae(ad adVar, af afVar) {
        this.b = adVar;
        this.a = afVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, int i) {
        Rect bj = this.b.a.bj();
        this.b.c.set((float) bj.left, (float) bj.top, (float) (view.getWidth() - bj.right), (float) (view.getHeight() - bj.bottom));
        if (this.b.c.contains(pointF.x, pointF.y)) {
            this.a.a();
            this.b.e();
        }
    }
}

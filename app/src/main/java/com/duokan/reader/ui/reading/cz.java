package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.ce;
import com.duokan.core.ui.er;

class cz implements ce {
    final /* synthetic */ cy a;

    cz(cy cyVar) {
        this.a = cyVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, float f) {
        this.a.i = true;
        this.a.a.d.a(new Point((int) pointF.x, (int) pointF.y), f);
        this.a.c(true);
        this.a.d(true);
    }
}

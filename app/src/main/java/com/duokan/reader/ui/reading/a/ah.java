package com.duokan.reader.ui.reading.a;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.er;
import com.duokan.core.ui.r;

class ah implements r {
    final /* synthetic */ ag a;

    ah(ag agVar) {
        this.a = agVar;
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        boolean z;
        ak a = this.a.a;
        if (Float.compare(pointF2.x, 0.0f) > 0) {
            z = true;
        } else {
            z = false;
        }
        a.a(z);
        this.a.f = false;
        this.a.d(true);
    }
}

package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class ay implements du {
    final /* synthetic */ ax a;

    ay(ax axVar) {
        this.a = axVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        this.a.a.t = this.a.a.t + pointF2.y;
        if (this.a.a.t < ((float) this.a.a.i)) {
            this.a.a.i();
        } else if (this.a.a.t >= ((float) (this.a.a.l.getHeight() - this.a.a.j))) {
            this.a.a.j();
        }
        this.a.a.c.invalidate();
    }
}

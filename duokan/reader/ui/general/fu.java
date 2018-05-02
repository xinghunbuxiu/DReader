package com.duokan.reader.ui.general;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class fu implements du {
    final /* synthetic */ fs a;

    fu(fs fsVar) {
        this.a = fsVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        this.a.e.x = Math.max(0.0f, this.a.e.x + pointF2.x);
        fy l = this.a.a.l();
        if (l != null) {
            this.a.a(l, Math.round(this.a.e.x), Math.round(this.a.e.x), 0, null);
        }
    }
}

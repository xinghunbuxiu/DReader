package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.Scrollable.ScrollState;

class fh implements r {
    final /* synthetic */ ff a;

    fh(ff ffVar) {
        this.a = ffVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        float f = 0.0f;
        if (this.a.a.s == ScrollState.SEEK) {
            this.a.a.a(ScrollState.IDLE);
            this.a.a.ad();
        } else if (this.a.a.s == ScrollState.DRAG) {
            this.a.a.a(ScrollState.FLING);
            ev evVar = this.a.a;
            float f2 = pointF.x;
            float f3 = pointF.y;
            float f4 = this.a.a.v ? pointF2.x : 0.0f;
            if (this.a.a.w) {
                f = pointF2.y;
            }
            evVar.a(f2, f3, f4, f, new fi(this), null);
            this.a.a.b(this.a.a.s, pointF.x, pointF.y);
        }
    }
}

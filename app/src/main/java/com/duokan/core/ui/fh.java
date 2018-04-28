package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.Scrollable.ScrollState;

class fh implements C0382r {
    /* renamed from: a */
    final /* synthetic */ ff f1253a;

    fh(ff ffVar) {
        this.f1253a = ffVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo528a(er erVar, View view, PointF pointF, PointF pointF2) {
        float f = 0.0f;
        if (this.f1253a.f1249a.f952s == ScrollState.SEEK) {
            this.f1253a.f1249a.m1416a(ScrollState.IDLE);
            this.f1253a.f1249a.ad();
        } else if (this.f1253a.f1249a.f952s == ScrollState.DRAG) {
            this.f1253a.f1249a.m1416a(ScrollState.FLING);
            ev evVar = this.f1253a.f1249a;
            float f2 = pointF.x;
            float f3 = pointF.y;
            float f4 = this.f1253a.f1249a.f955v ? pointF2.x : 0.0f;
            if (this.f1253a.f1249a.f956w) {
                f = pointF2.y;
            }
            evVar.mo1768a(f2, f3, f4, f, new fi(this), null);
            this.f1253a.f1249a.mo1761b(this.f1253a.f1249a.f952s, pointF.x, pointF.y);
        }
    }
}

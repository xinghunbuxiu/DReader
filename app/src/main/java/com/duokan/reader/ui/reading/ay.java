package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class ay implements du {
    /* renamed from: a */
    final /* synthetic */ ax f9811a;

    ay(ax axVar) {
        this.f9811a = axVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        this.f9811a.f9809a.f9801t = this.f9811a.f9809a.f9801t + pointF2.y;
        if (this.f9811a.f9809a.f9801t < ((float) this.f9811a.f9809a.f9790i)) {
            this.f9811a.f9809a.m13747i();
        } else if (this.f9811a.f9809a.f9801t >= ((float) (this.f9811a.f9809a.f9793l.getHeight() - this.f9811a.f9809a.f9791j))) {
            this.f9811a.f9809a.m13748j();
        }
        this.f9811a.f9809a.f9784c.invalidate();
    }
}

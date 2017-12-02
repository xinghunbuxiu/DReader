package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.bw;

class lk implements bw {
    final /* synthetic */ lj a;

    lk(lj ljVar) {
        this.a = ljVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(View view, PointF pointF) {
        fu a = this.a.a(pointF.x, pointF.y);
        if (a != null) {
            this.a.a.b(a);
        }
    }
}

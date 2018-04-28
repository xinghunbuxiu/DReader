package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class dc implements du {
    /* renamed from: a */
    final /* synthetic */ MotionEvent f9985a;
    /* renamed from: b */
    final /* synthetic */ da f9986b;

    dc(da daVar, MotionEvent motionEvent) {
        this.f9986b = daVar;
        this.f9985a = motionEvent;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (Float.compare(this.f9986b.f9975a.f9952d.getFrameScale(), 1.0f) > 0) {
            if (this.f9986b.f9983j) {
                this.f9986b.f9975a.f9952d.m13306a((int) pointF2.x, (int) pointF2.y, false);
            } else if (this.f9985a.getPointerCount() < 2) {
                this.f9986b.f9983j = true;
                this.f9986b.m1617c(true);
            }
        }
    }
}

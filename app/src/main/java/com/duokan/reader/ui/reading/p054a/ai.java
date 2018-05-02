package com.duokan.reader.ui.reading.p054a;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

/* renamed from: com.duokan.reader.ui.reading.a.ai */
class ai implements du {
    /* renamed from: a */
    final /* synthetic */ MotionEvent f9196a;
    /* renamed from: b */
    final /* synthetic */ ag f9197b;

    ai(ag agVar, MotionEvent motionEvent) {
        this.f9197b = agVar;
        this.f9196a = motionEvent;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (this.f9196a.getPointerCount() > 1 && !this.f9197b.f9194f && ((this.f9197b.f9190a.mo2447e() && Float.compare(pointF2.x, 0.0f) < 0) || (!this.f9197b.f9190a.mo2447e() && Float.compare(pointF2.x, 0.0f) > 0))) {
            this.f9197b.f9194f = true;
            this.f9197b.m1617c(true);
            this.f9197b.m1620d(true);
            this.f9197b.f9190a.mo2448f();
        } else if (this.f9197b.f9194f) {
            this.f9197b.f9190a.mo2444a(pointF2.x, pointF2.y);
        }
    }
}

package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.C0382r;
import com.duokan.core.ui.er;

class dd implements C0382r {
    /* renamed from: a */
    final /* synthetic */ da f9987a;

    dd(da daVar) {
        this.f9987a = daVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo528a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (this.f9987a.f9982i || Float.compare(this.f9987a.f9975a.f9952d.getFrameScale(), 1.0f) != 0) {
            this.f9987a.f9975a.f9952d.m13305a(pointF2.x, pointF2.y);
        } else if (pointF2.x > 0.0f) {
            this.f9987a.f9975a.mo2296g();
            this.f9987a.m1620d(true);
        } else if (pointF2.x < 0.0f) {
            this.f9987a.f9975a.mo2297h();
            this.f9987a.m1620d(true);
        }
        this.f9987a.m1613b(false);
    }
}

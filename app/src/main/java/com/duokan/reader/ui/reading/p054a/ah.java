package com.duokan.reader.ui.reading.p054a;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.C0382r;
import com.duokan.core.ui.er;

/* renamed from: com.duokan.reader.ui.reading.a.ah */
class ah implements C0382r {
    /* renamed from: a */
    final /* synthetic */ ag f9195a;

    ah(ag agVar) {
        this.f9195a = agVar;
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo528a(er erVar, View view, PointF pointF, PointF pointF2) {
        boolean z;
        ak a = this.f9195a.f9190a;
        if (Float.compare(pointF2.x, 0.0f) > 0) {
            z = true;
        } else {
            z = false;
        }
        a.mo2446a(z);
        this.f9195a.f9194f = false;
        this.f9195a.m1620d(true);
    }
}

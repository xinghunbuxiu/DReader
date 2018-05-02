package com.duokan.reader.ui.reading.p054a;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.du;
import com.duokan.core.ui.er;
import org.apache.http.HttpStatus;

/* renamed from: com.duokan.reader.ui.reading.a.h */
class C1427h implements du {
    /* renamed from: a */
    final /* synthetic */ MotionEvent f9218a;
    /* renamed from: b */
    final /* synthetic */ C1428i f9219b;
    /* renamed from: c */
    final /* synthetic */ C1426g f9220c;

    C1427h(C1426g c1426g, MotionEvent motionEvent, C1428i c1428i) {
        this.f9220c = c1426g;
        this.f9218a = motionEvent;
        this.f9219b = c1428i;
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (this.f9218a.getPointerCount() != 2) {
            this.f9220c.m1613b(false);
            return;
        }
        this.f9219b.mo2488a((-pointF2.y) / ((float) this.f9220c.m1603a(view, (int) HttpStatus.SC_OK)));
        this.f9220c.m1617c(true);
    }
}

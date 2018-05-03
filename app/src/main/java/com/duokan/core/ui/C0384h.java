package com.duokan.core.ui;

import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.duokan.core.ui.h */
class C0384h implements cu {
    /* renamed from: a */
    final /* synthetic */ boolean f1322a;
    /* renamed from: b */
    final /* synthetic */ long f1323b;
    /* renamed from: c */
    final /* synthetic */ C0385i f1324c;
    /* renamed from: d */
    final /* synthetic */ MotionEvent f1325d;
    /* renamed from: e */
    final /* synthetic */ C0383g f1326e;

    C0384h(C0383g c0383g, boolean z, long j, C0385i c0385i, MotionEvent motionEvent) {
        this.f1326e = c0383g;
        this.f1322a = z;
        this.f1323b = j;
        this.f1324c = c0385i;
        this.f1325d = motionEvent;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        this.f1326e.f1285e = this.f1326e.f1285e + 1;
        if (this.f1326e.f1285e > this.f1326e.f1283c) {
            this.f1326e.m1613b(false);
        } else if (this.f1326e.f1285e == this.f1326e.f1283c) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (!this.f1322a || uptimeMillis - this.f1323b >= ((long) AnimUtils.getDoubleTapTimeout())) {
                this.f1326e.m1613b(false);
                this.f1324c.mo1788a(this.f1326e, view, pointF, this.f1326e.f1283c);
            }
        }
        this.f1326e.f1286f = pointF;
        this.f1326e.f1287g = this.f1325d.getEventTime();
    }
}

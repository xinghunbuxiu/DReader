package com.duokan.core.ui;

import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;

class h implements cu {
    final /* synthetic */ boolean a;
    final /* synthetic */ long b;
    final /* synthetic */ i c;
    final /* synthetic */ MotionEvent d;
    final /* synthetic */ g e;

    h(g gVar, boolean z, long j, i iVar, MotionEvent motionEvent) {
        this.e = gVar;
        this.a = z;
        this.b = j;
        this.c = iVar;
        this.d = motionEvent;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        this.e.e = this.e.e + 1;
        if (this.e.e > this.e.c) {
            this.e.b(false);
        } else if (this.e.e == this.e.c) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (!this.a || uptimeMillis - this.b >= ((long) UTools.getScaledTouchSlop())) {
                this.e.b(false);
                this.c.a(this.e, view, pointF, this.e.c);
            }
        }
        this.e.f = pointF;
        this.e.g = this.d.getEventTime();
    }
}

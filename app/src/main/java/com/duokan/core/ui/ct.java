package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

public class ct extends er {
    private MotionEvent a = null;

    protected void a(View view, boolean z) {
        a(null);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (esVar instanceof cu) {
            cu cuVar = (cu) esVar;
            if (this.a == null) {
                if (motionEvent.getPointerCount() == 1) {
                    a(motionEvent);
                    return;
                }
                return;
            } else if (motionEvent.getPointerCount() > 1) {
                b(false);
                return;
            } else if (motionEvent.getEventTime() - this.a.getEventTime() > ((long) dv.b())) {
                b(false);
                return;
            } else {
                PointF pointF = new PointF(this.a.getX(), this.a.getY());
                PointF pointF2 = new PointF(motionEvent.getX(), motionEvent.getY());
                if (d(pointF, pointF2) > ((double) b(view))) {
                    b(false);
                    return;
                } else if (motionEvent.getAction() == 1) {
                    cuVar.onTap(this, view, pointF2);
                    return;
                } else {
                    return;
                }
            }
        }
        b(false);
    }

    private void a(MotionEvent motionEvent) {
        if (this.a != null) {
            this.a.recycle();
            this.a = null;
        }
        if (motionEvent != null) {
            this.a = MotionEvent.obtain(motionEvent);
        }
    }
}

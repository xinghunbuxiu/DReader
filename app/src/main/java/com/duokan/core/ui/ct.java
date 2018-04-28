package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

public class ct extends er {
    /* renamed from: a */
    private MotionEvent f1092a = null;

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        m1784a(null);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (esVar instanceof cu) {
            cu cuVar = (cu) esVar;
            if (this.f1092a == null) {
                if (motionEvent.getPointerCount() == 1) {
                    m1784a(motionEvent);
                    return;
                }
                return;
            } else if (motionEvent.getPointerCount() > 1) {
                m1613b(false);
                return;
            } else if (motionEvent.getEventTime() - this.f1092a.getEventTime() > ((long) dv.getJumpTapTimeout())) {
                m1613b(false);
                return;
            } else {
                PointF pointF = new PointF(this.f1092a.getX(), this.f1092a.getY());
                PointF pointF2 = new PointF(motionEvent.getX(), motionEvent.getY());
                if (m1619d(pointF, pointF2) > ((double) m1610b(view))) {
                    m1613b(false);
                    return;
                } else if (motionEvent.getAction() == 1) {
                    cuVar.onTap(this, view, pointF2);
                    return;
                } else {
                    return;
                }
            }
        }
        m1613b(false);
    }

    /* renamed from: a */
    private void m1784a(MotionEvent motionEvent) {
        if (this.f1092a != null) {
            this.f1092a.recycle();
            this.f1092a = null;
        }
        if (motionEvent != null) {
            this.f1092a = MotionEvent.obtain(motionEvent);
        }
    }
}

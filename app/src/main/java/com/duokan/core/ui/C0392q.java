package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

/* renamed from: com.duokan.core.ui.q */
public class C0392q extends er {
    /* renamed from: a */
    private final PointF f1331a = new PointF();
    /* renamed from: c */
    private VelocityTracker f1332c = null;
    /* renamed from: d */
    private float f1333d = Float.NaN;
    /* renamed from: e */
    private float f1334e = Float.NaN;
    /* renamed from: f */
    private float f1335f = 0.0f;
    /* renamed from: g */
    private float f1336g = 180.0f;

    /* renamed from: a */
    public void m2168a(float f) {
        this.f1333d = f;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        if (z) {
            if (this.f1332c != null) {
                this.f1332c.recycle();
                this.f1332c = null;
            }
        } else if (this.f1332c != null) {
            this.f1332c.clear();
        }
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (esVar instanceof C0382r) {
            C0382r c0382r = (C0382r) esVar;
            MotionEvent a = dv.m1908a(motionEvent, view, null);
            if (this.f1332c == null) {
                this.f1332c = VelocityTracker.obtain();
            }
            this.f1332c.addMovement(a);
            if (motionEvent.getActionMasked() == 0) {
                this.f1331a.set(a.getX(), a.getY());
            }
            if (motionEvent.getActionMasked() == 1) {
                if (m1619d(this.f1331a, new PointF(a.getX(), a.getY())) >= ((double) dv.getScaledTouchSlop(view.getContext()))) {
                    float b = Float.isNaN(this.f1333d) ? (float) dv.getScaledMinimumFlingVelocity(view.getContext()) : this.f1333d;
                    this.f1332c.computeCurrentVelocity(1000, Float.isNaN(this.f1334e) ? (float) dv.getScaledMaximumFlingVelocity(view.getContext()) : this.f1334e);
                    PointF pointF = new PointF(this.f1332c.getXVelocity(), this.f1332c.getYVelocity());
                    if (Math.abs(pointF.x) < b) {
                        pointF.x = 0.0f;
                    }
                    if (Math.abs(pointF.y) < b) {
                        pointF.y = 0.0f;
                    }
                    dv.m1899a(pointF, view);
                    if (dv.m1924a(new PointF(0.0f, 0.0f), pointF, (double) this.f1335f, (double) this.f1336g) && !(Float.compare(Math.abs(pointF.x), 0.0f) == 0 && Float.compare(Math.abs(pointF.y), 0.0f) == 0)) {
                        c0382r.mo528a(this, view, new PointF(motionEvent.getX(0), motionEvent.getY(0)), pointF);
                    }
                }
            }
            a.recycle();
            return;
        }
        m1613b(false);
    }
}

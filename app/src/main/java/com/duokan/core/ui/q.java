package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

import miuipub.date.Calendar;

public class q extends er {
    private final PointF a = new PointF();
    private VelocityTracker c = null;
    private float d = Float.NaN;
    private float e = Float.NaN;
    private float f = 0.0f;
    private float g = 180.0f;

    public void a(float f) {
        this.d = f;
    }

    protected void a(View view, boolean z) {
        if (z) {
            if (this.c != null) {
                this.c.recycle();
                this.c = null;
            }
        } else if (this.c != null) {
            this.c.clear();
        }
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (esVar instanceof r) {
            r rVar = (r) esVar;
            MotionEvent a = dv.a(motionEvent, view, null);
            if (this.c == null) {
                this.c = VelocityTracker.obtain();
            }
            this.c.addMovement(a);
            if (motionEvent.getActionMasked() == 0) {
                this.a.set(a.getX(), a.getY());
            }
            if (motionEvent.getActionMasked() == 1) {
                if (d(this.a, new PointF(a.getX(), a.getY())) >= ((double) dv.d(view.getContext()))) {
                    float b = Float.isNaN(this.d) ? (float) dv.b(view.getContext()) : this.d;
                    this.c.computeCurrentVelocity(Calendar.MILLISECOND_OF_SECOND, Float.isNaN(this.e) ? (float) dv.c(view.getContext()) : this.e);
                    PointF pointF = new PointF(this.c.getXVelocity(), this.c.getYVelocity());
                    if (Math.abs(pointF.x) < b) {
                        pointF.x = 0.0f;
                    }
                    if (Math.abs(pointF.y) < b) {
                        pointF.y = 0.0f;
                    }
                    dv.a(pointF, view);
                    if (dv.a(new PointF(0.0f, 0.0f), pointF, (double) this.f, (double) this.g) && !(Float.compare(Math.abs(pointF.x), 0.0f) == 0 && Float.compare(Math.abs(pointF.y), 0.0f) == 0)) {
                        rVar.a(this, view, new PointF(motionEvent.getX(0), motionEvent.getY(0)), pointF);
                    }
                }
            }
            a.recycle();
            return;
        }
        b(false);
    }
}

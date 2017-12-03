package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

public class bu extends er {
    private MotionEvent a = null;
    private MotionEvent c = null;
    private bv d = null;
    private boolean e = false;

    protected void a(View view, boolean z) {
        if (this.a != null) {
            this.a.recycle();
            this.a = null;
        }
        if (this.c != null) {
            this.c.recycle();
            this.c = null;
        }
        this.d = null;
        this.e = false;
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (esVar instanceof bw) {
            bw bwVar = (bw) esVar;
            if (motionEvent.getPointerCount() > 1) {
                b(false);
                this.d = null;
                return;
            } else if (this.a == null && motionEvent.getActionMasked() == 0) {
                this.a = MotionEvent.obtainNoHistory(motionEvent);
                this.d = new bv(this, view);
                view.postDelayed(this.d, (long) UTools.addAnimation());
                return;
            } else if (this.a == null) {
                b(false);
                this.d = null;
                return;
            } else {
                if (this.c != null) {
                    this.c.recycle();
                    this.c = null;
                }
                this.c = MotionEvent.obtainNoHistory(motionEvent);
                if (d(new PointF(this.a.getRawX(), this.a.getRawY()), new PointF(this.c.getRawX(), this.c.getRawY())) > ((double) b(view))) {
                    b(false);
                    this.d = null;
                    return;
                } else if (this.e) {
                    bwVar.a(view, new PointF(this.c.getX(0), this.c.getY(0)));
                    b(false);
                    this.d = null;
                    return;
                } else {
                    return;
                }
            }
        }
        b(false);
        this.d = null;
    }
}

package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

public class g extends er {
    static final /* synthetic */ boolean a = (!g.class.desiredAssertionStatus());
    private final int c;
    private final ct d;
    private int e;
    private PointF f;
    private long g;

    public g() {
        this(1);
    }

    public g(int i) {
        this.d = new ct();
        this.e = 0;
        this.f = new PointF();
        this.g = 0;
        if (a || i > 0) {
            this.c = i;
            return;
        }
        throw new AssertionError();
    }

    protected void a(View view, boolean z) {
        this.d.b(view, z);
        if (z) {
            this.e = 0;
            this.f = new PointF();
            this.g = 0;
        }
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        boolean z2 = true;
        if (motionEvent.getActionMasked() == 3) {
            b(false);
        } else if (esVar instanceof i) {
            i iVar = (i) esVar;
            long eventTime = motionEvent.getEventTime();
            if (this.e <= 0 || (eventTime - this.g < ((long) UTools.getScaledTouchSlop()) && UTools.getTriangleEdge(new PointF(motionEvent.getX(), motionEvent.getY()), this.f) <= ((double) UTools.getScaledPagingTouchSlop(view.getContext())))) {
                e(this.e < this.c + -1);
                this.d.b(view, motionEvent, z, new h(this, z, eventTime, iVar, motionEvent));
                if (!(c() && this.d.c())) {
                    z2 = false;
                }
                b(z2);
                return;
            }
            b(false);
        } else {
            b(false);
        }
    }
}

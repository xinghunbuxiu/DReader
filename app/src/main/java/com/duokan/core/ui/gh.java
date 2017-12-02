package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.ZoomView.ZoomState;

class gh extends er {
    final /* synthetic */ ZoomView a;
    private final cd c;
    private final cb d;
    private final g e;
    private final PointF f;
    private boolean g;
    private final PointF h;
    private float i;
    private float j;

    private gh(ZoomView zoomView) {
        this.a = zoomView;
        this.c = new cd();
        this.d = new cb();
        this.e = new g(2);
        this.f = new PointF();
        this.g = false;
        this.h = new PointF();
        this.i = 0.0f;
        this.j = 0.0f;
    }

    protected void a(View view, boolean z) {
        boolean z2 = true;
        cd cdVar = this.c;
        boolean z3 = z || !this.c.c();
        cdVar.b(view, z3);
        this.d.a(this.a.k);
        cb cbVar = this.d;
        if (z || !this.d.c()) {
            z3 = true;
        } else {
            z3 = false;
        }
        cbVar.b(view, z3);
        g gVar = this.e;
        if (!z && this.e.c()) {
            z2 = false;
        }
        gVar.b(view, z2);
        this.c.a(0.01f);
        this.c.a(dv.e(view.getContext()));
        this.f.set(0.0f, 0.0f);
        this.h.set(0.0f, 0.0f);
        this.g = false;
        this.i = 0.0f;
        this.j = 0.0f;
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        View d = this.a.e();
        if (d == null) {
            b(false);
            return;
        }
        boolean z2;
        this.c.b(view, motionEvent, z, new gi(this, d));
        this.d.b(view, motionEvent, z, new gj(this, d));
        if (this.g) {
            if (motionEvent.getActionMasked() == 1) {
                this.a.m_();
            } else {
                this.a.a(ZoomState.PINCH);
                this.a.c(this.f.x, this.f.y, this.h.x, this.h.y, this.i, this.j);
            }
        }
        e(this.e.f());
        if (this.c.c() || this.d.c() || this.e.c()) {
            z2 = true;
        } else {
            z2 = false;
        }
        b(z2);
    }
}

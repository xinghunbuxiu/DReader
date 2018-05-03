package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

public class bu extends er {
    /* renamed from: a */
    private MotionEvent f1033a = null;
    /* renamed from: c */
    private MotionEvent f1034c = null;
    /* renamed from: d */
    private bv f1035d = null;
    /* renamed from: e */
    private boolean f1036e = false;

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        if (this.f1033a != null) {
            this.f1033a.recycle();
            this.f1033a = null;
        }
        if (this.f1034c != null) {
            this.f1034c.recycle();
            this.f1034c = null;
        }
        this.f1035d = null;
        this.f1036e = false;
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (esVar instanceof bw) {
            bw bwVar = (bw) esVar;
            if (motionEvent.getPointerCount() > 1) {
                m1613b(false);
                this.f1035d = null;
                return;
            } else if (this.f1033a == null && motionEvent.getActionMasked() == 0) {
                this.f1033a = MotionEvent.obtainNoHistory(motionEvent);
                this.f1035d = new bv(this, view);
                view.postDelayed(this.f1035d, (long) AnimUtils.getLongPressTimeout());
                return;
            } else if (this.f1033a == null) {
                m1613b(false);
                this.f1035d = null;
                return;
            } else {
                if (this.f1034c != null) {
                    this.f1034c.recycle();
                    this.f1034c = null;
                }
                this.f1034c = MotionEvent.obtainNoHistory(motionEvent);
                if (m1619d(new PointF(this.f1033a.getRawX(), this.f1033a.getRawY()), new PointF(this.f1034c.getRawX(), this.f1034c.getRawY())) > ((double) m1610b(view))) {
                    m1613b(false);
                    this.f1035d = null;
                    return;
                } else if (this.f1036e) {
                    bwVar.mo521a(view, new PointF(this.f1034c.getX(0), this.f1034c.getY(0)));
                    m1613b(false);
                    this.f1035d = null;
                    return;
                } else {
                    return;
                }
            }
        }
        m1613b(false);
        this.f1035d = null;
    }
}

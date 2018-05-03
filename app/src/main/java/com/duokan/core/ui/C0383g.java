package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.duokan.core.ui.g */
public class C0383g extends er {
    /* renamed from: a */
    static final /* synthetic */ boolean f1282a = (!C0383g.class.desiredAssertionStatus());
    /* renamed from: c */
    private final int f1283c;
    /* renamed from: d */
    private final ct f1284d;
    /* renamed from: e */
    private int f1285e;
    /* renamed from: f */
    private PointF f1286f;
    /* renamed from: g */
    private long f1287g;

    public C0383g() {
        this(1);
    }

    public C0383g(int i) {
        this.f1284d = new ct();
        this.f1285e = 0;
        this.f1286f = new PointF();
        this.f1287g = 0;
        if (f1282a || i > 0) {
            this.f1283c = i;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f1284d.m1612b(view, z);
        if (z) {
            this.f1285e = 0;
            this.f1286f = new PointF();
            this.f1287g = 0;
        }
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        boolean z2 = true;
        if (motionEvent.getActionMasked() == 3) {
            m1613b(false);
        } else if (esVar instanceof C0385i) {
            C0385i c0385i = (C0385i) esVar;
            long eventTime = motionEvent.getEventTime();
            if (this.f1285e <= 0 || (eventTime - this.f1287g < ((long) AnimUtils.getDoubleTapTimeout()) && AnimUtils.m1949d(new PointF(motionEvent.getX(), motionEvent.getY()), this.f1286f) <= ((double) AnimUtils.getScaledPagingTouchSlop(view.getContext())))) {
                m1622e(this.f1285e < this.f1283c + -1);
                this.f1284d.m1611b(view, motionEvent, z, new C0384h(this, z, eventTime, c0385i, motionEvent));
                if (!(m1618c() && this.f1284d.m1618c())) {
                    z2 = false;
                }
                m1613b(z2);
                return;
            }
            m1613b(false);
        } else {
            m1613b(false);
        }
    }
}

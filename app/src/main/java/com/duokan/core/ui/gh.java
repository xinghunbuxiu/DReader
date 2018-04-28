package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.ZoomView.ZoomState;

class gh extends er {
    /* renamed from: a */
    final /* synthetic */ ZoomView f1309a;
    /* renamed from: c */
    private final cd f1310c;
    /* renamed from: d */
    private final cb f1311d;
    /* renamed from: e */
    private final C0383g f1312e;
    /* renamed from: f */
    private final PointF f1313f;
    /* renamed from: g */
    private boolean f1314g;
    /* renamed from: h */
    private final PointF f1315h;
    /* renamed from: i */
    private float f1316i;
    /* renamed from: j */
    private float f1317j;

    private gh(ZoomView zoomView) {
        this.f1309a = zoomView;
        this.f1310c = new cd();
        this.f1311d = new cb();
        this.f1312e = new C0383g(2);
        this.f1313f = new PointF();
        this.f1314g = false;
        this.f1315h = new PointF();
        this.f1316i = 0.0f;
        this.f1317j = 0.0f;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        boolean z2 = true;
        cd cdVar = this.f1310c;
        boolean z3 = z || !this.f1310c.m1618c();
        cdVar.m1612b(view, z3);
        this.f1311d.m1607a(this.f1309a.f879k);
        cb cbVar = this.f1311d;
        if (z || !this.f1311d.m1618c()) {
            z3 = true;
        } else {
            z3 = false;
        }
        cbVar.m1612b(view, z3);
        C0383g c0383g = this.f1312e;
        if (!z && this.f1312e.m1618c()) {
            z2 = false;
        }
        c0383g.m1612b(view, z2);
        this.f1310c.m1756a(0.01f);
        this.f1310c.m1757a(dv.getScaledPagingTouchSlop(view.getContext()));
        this.f1313f.set(0.0f, 0.0f);
        this.f1315h.set(0.0f, 0.0f);
        this.f1314g = false;
        this.f1316i = 0.0f;
        this.f1317j = 0.0f;
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        View d = this.f1309a.mo2335e();
        if (d == null) {
            m1613b(false);
            return;
        }
        boolean z2;
        this.f1310c.m1611b(view, motionEvent, z, new gi(this, d));
        this.f1311d.m1611b(view, motionEvent, z, new gj(this, d));
        if (this.f1314g) {
            if (motionEvent.getActionMasked() == 1) {
                this.f1309a.n_();
            } else {
                this.f1309a.m1332a(ZoomState.PINCH);
                this.f1309a.m1344c(this.f1313f.x, this.f1313f.y, this.f1315h.x, this.f1315h.y, this.f1316i, this.f1317j);
            }
        }
        m1622e(this.f1312e.m1624f());
        if (this.f1310c.m1618c() || this.f1311d.m1618c() || this.f1312e.m1618c()) {
            z2 = true;
        } else {
            z2 = false;
        }
        m1613b(z2);
    }
}

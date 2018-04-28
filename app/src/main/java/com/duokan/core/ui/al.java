package com.duokan.core.ui;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.duokan.core.ui.HatGridView.HatTipState;

class al extends bh {
    /* renamed from: a */
    final /* synthetic */ ak f961a;

    al(ak akVar) {
        this.f961a = akVar;
        super(akVar);
    }

    /* renamed from: a */
    protected void mo502a(MotionEvent motionEvent) {
        super.mo502a(motionEvent);
        this.f961a.f919b.mo1622a(motionEvent);
    }

    /* renamed from: a */
    protected void mo503a(ScrollState scrollState, RectF rectF) {
        this.f961a.f919b.mo1750a(scrollState, rectF);
    }

    /* renamed from: a */
    protected void mo501a(float f, float f2) {
        PointF pointF = (PointF) dv.f1197f.addAnimation();
        pointF.set(f, f2);
        this.f961a.f919b.mo1621a(pointF);
        float f3 = pointF.x;
        float f4 = pointF.y;
        dv.f1197f.clearAnimation(pointF);
        this.f961a.f919b.f835y = (int) (((float) this.f961a.f919b.f835y) + f4);
        if (Math.abs(this.f961a.f919b.f835y) > dv.getScaledTouchSlop(this.f961a.getContext())) {
            if (this.f961a.f919b.f835y > 0) {
                this.f961a.f919b.m1236w();
            } else if (this.f961a.f919b.f835y < 0) {
                this.f961a.f919b.m1237x();
            }
            if (this.f961a.f919b.f835y > 0) {
                if (this.f961a.f919b.m1252b()) {
                    this.f961a.f919b.m1191a(HatTipState.DOCKING);
                } else {
                    this.f961a.f919b.m1191a(HatTipState.UNDOCKING);
                }
            } else if (this.f961a.f919b.f835y < 0) {
                this.f961a.f919b.m1191a(HatTipState.UNDOCKING);
            }
            this.f961a.f919b.f835y = 0;
        }
        int min = Math.min(0, m1553k().top);
        if (Float.compare(((float) getViewportBounds().top) - f4, (float) min) >= 0) {
            super.m1518b(this.f961a.f919b.f824n);
        } else if (Float.compare(((float) getViewportBounds().top) - f4, (float) min) < 0 && this.f961a.f919b.f832v) {
            super.m1518b(OverScrollMode.ALWAYS);
        }
        super.mo501a(f3, f4);
    }

    /* renamed from: a */
    protected int mo500a() {
        if (!this.f961a.f919b.f832v) {
            return super.mo500a();
        }
        if (this.f961a.f919b.f834x == HatTipState.DOCKED || this.f961a.f919b.f834x == HatTipState.DOCKING) {
            return Math.max(super.mo500a() - this.f961a.f919b.m1223q(), 0);
        }
        return super.mo500a();
    }

    /* renamed from: b */
    protected int mo504b() {
        if (this.f961a.f919b.f810D > 0) {
            return this.f961a.f919b.f810D;
        }
        if (this.f961a.f919b.f834x == HatTipState.DOCKED || this.f961a.f919b.f834x == HatTipState.DOCKING) {
            return super.mo504b() - this.f961a.f919b.m1223q();
        }
        return super.mo504b();
    }
}

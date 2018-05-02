package com.duokan.core.ui;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;

import com.duokan.core.ui.HatGridView.HatTipState;

class al extends bh {
    final /* synthetic */ ak a;

    al(ak akVar) {
        this.a = akVar;
        super(akVar);
    }

    protected void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        if (motionEvent.getActionMasked() == 0) {
            if (this.a.b.v) {
                this.a.b.a.setVerticalOverScrollMode(OverScrollMode.ALWAYS);
            } else {
                this.a.b.a.setVerticalOverScrollMode(this.a.b.n);
            }
        } else if (motionEvent.getActionMasked() != 1 && motionEvent.getActionMasked() == 3) {
        }
    }

    protected void a(ScrollState scrollState, RectF rectF) {
        this.a.b.a(scrollState, rectF);
    }

    protected void a(float f, float f2) {
        PointF pointF = (PointF) UTools.f.getRect();
        pointF.set(f, f2);
        this.a.b.a(pointF);
        float f3 = pointF.x;
        float f4 = pointF.y;
        UTools.f.getRect(pointF);
        this.a.b.y = (int) (((float) this.a.b.y) + f4);
        if (Math.abs(this.a.b.y) > UTools.getScaledTouchSlop(this.a.getContext())) {
            if (this.a.b.y > 0) {
                this.a.b.w();
            } else if (this.a.b.y < 0) {
                this.a.b.x();
            }
            if (this.a.b.y > 0) {
                if (this.a.b.b()) {
                    this.a.b.a(HatTipState.DOCKING);
                } else {
                    this.a.b.a(HatTipState.UNDOCKING);
                }
            } else if (this.a.b.y < 0) {
                this.a.b.a(HatTipState.UNDOCKING);
            }
            this.a.b.y = 0;
        }
        int min = Math.min(0, k().top);
        if (Float.compare(((float) getViewportBounds().top) - f4, (float) min) >= 0) {
            super.b(this.a.b.n);
        } else if (Float.compare(((float) getViewportBounds().top) - f4, (float) min) < 0 && this.a.b.v) {
            super.b(OverScrollMode.ALWAYS);
        }
        super.a(f3, f4);
    }

    protected int a() {
        if (!this.a.b.v) {
            return super.a();
        }
        if (this.a.b.x == HatTipState.DOCKED || this.a.b.x == HatTipState.DOCKING) {
            return Math.max(super.a() - this.a.b.q(), 0);
        }
        return super.a();
    }

    protected int b() {
        if (this.a.b.x == HatTipState.DOCKED || this.a.b.x == HatTipState.DOCKING) {
            return super.b() - this.a.b.q();
        }
        return super.b();
    }
}

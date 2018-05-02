package com.duokan.reader.ui.reading.p054a;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import com.duokan.core.ui.C0385i;
import com.duokan.core.ui.er;
import com.duokan.reader.ui.reading.C1455g;
import com.duokan.reader.ui.reading.PageAnimationMode;

/* renamed from: com.duokan.reader.ui.reading.a.k */
class C1430k implements C0385i {
    /* renamed from: a */
    final /* synthetic */ C1429j f9224a;

    C1430k(C1429j c1429j) {
        this.f9224a = c1429j;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo1788a(er erVar, View view, PointF pointF, int i) {
        Rect bk = this.f9224a.f9221a.bk();
        this.f9224a.f9222c.set((float) bk.left, (float) bk.top, (float) (view.getWidth() - bk.right), (float) (view.getHeight() - bk.bottom));
        if (this.f9224a.f9222c.contains(pointF.x, pointF.y)) {
            this.f9224a.m1613b(false);
            return;
        }
        if (this.f9224a.f9221a.bg()) {
            C1455g bh = this.f9224a.f9221a.bh();
            if (bh != null && bh.m14192a().contains((int) pointF.x, (int) pointF.y)) {
                bh.m14195b();
                this.f9224a.m1613b(false);
                return;
            }
        }
        if (this.f9224a.f9221a.mo2004U() == PageAnimationMode.VSCROLL) {
            if (pointF.y < this.f9224a.f9222c.top) {
                this.f9224a.f9221a.mo2018a(pointF, null, null);
                this.f9224a.m1620d(true);
            } else if (pointF.y > this.f9224a.f9222c.bottom) {
                this.f9224a.f9221a.mo2099b(pointF, null, null);
                this.f9224a.m1620d(true);
            }
        } else if (this.f9224a.f9221a.al()) {
            if (pointF.x < this.f9224a.f9222c.left) {
                this.f9224a.f9221a.mo2099b(pointF, null, null);
                this.f9224a.m1620d(true);
            } else if (pointF.x > this.f9224a.f9222c.right) {
                if (!this.f9224a.f9221a.aL()) {
                    this.f9224a.f9221a.mo2018a(pointF, null, null);
                    this.f9224a.m1620d(true);
                } else if (this.f9224a.f9221a.aL()) {
                    this.f9224a.f9221a.mo2099b(pointF, null, null);
                    this.f9224a.m1620d(true);
                }
            } else if (pointF.y < this.f9224a.f9222c.top) {
                this.f9224a.f9221a.mo2018a(pointF, null, null);
                this.f9224a.m1620d(true);
            } else if (pointF.y > this.f9224a.f9222c.bottom) {
                this.f9224a.f9221a.mo2099b(pointF, null, null);
                this.f9224a.m1620d(true);
            }
        } else if (pointF.x < this.f9224a.f9222c.left) {
            if (!this.f9224a.f9221a.aL()) {
                this.f9224a.f9221a.mo2018a(pointF, null, null);
                this.f9224a.m1620d(true);
            } else if (this.f9224a.f9221a.aL()) {
                this.f9224a.f9221a.mo2099b(pointF, null, null);
                this.f9224a.m1620d(true);
            }
        } else if (pointF.x > this.f9224a.f9222c.right) {
            this.f9224a.f9221a.mo2099b(pointF, null, null);
            this.f9224a.m1620d(true);
        } else if (pointF.y < this.f9224a.f9222c.top) {
            this.f9224a.f9221a.mo2018a(pointF, null, null);
            this.f9224a.m1620d(true);
        } else if (pointF.y > this.f9224a.f9222c.bottom) {
            this.f9224a.f9221a.mo2099b(pointF, null, null);
            this.f9224a.m1620d(true);
        }
        this.f9224a.m1613b(false);
    }
}

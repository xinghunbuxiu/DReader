package com.duokan.core.ui;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;

public class bh extends ev {
    /* renamed from: b */
    final /* synthetic */ ay f960b;

    public bh(ay ayVar) {
        this.f960b = ayVar;
        super(ayVar);
    }

    /* renamed from: a */
    protected void mo494a(ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState == ScrollState.IDLE && scrollState2 == ScrollState.DRAG) {
            this.f960b.mo1756o();
        }
    }

    /* renamed from: a */
    protected void mo495a(boolean z) {
        if (z) {
            this.f960b.m1152k();
        }
        this.f960b.m1155l();
    }

    /* renamed from: a */
    protected void mo493a(PointF pointF) {
        if (this.f960b.f788y == ScrollState.IDLE) {
            if ((this.f960b.f763E != null || this.f960b.f764F != null) && !this.f960b.mo1757p()) {
                Point point = new Point(Math.round(pointF.x), Math.round(pointF.y));
                m1508b(point);
                this.f960b.f759A = this.f960b.mo447a(point);
                if (this.f960b.f759A >= 0) {
                    this.f960b.mo445a(this.f960b.f759A);
                }
            }
        }
    }

    /* renamed from: b */
    protected void mo496b(PointF pointF) {
        if (this.f960b.f759A >= 0) {
            this.f960b.mo1756o();
            this.f960b.f759A = -1;
        }
    }

    /* renamed from: c */
    protected void mo497c(PointF pointF) {
        this.f960b.mo1756o();
        this.f960b.f759A = -1;
    }

    /* renamed from: d */
    protected void mo498d(PointF pointF) {
        if (this.f960b.f763E == null || this.f960b.f759A < 0) {
            super.mo498d(pointF);
            return;
        }
        this.f960b.m1073a(new bi(this, this.f960b.f759A));
        this.f960b.f759A = -1;
    }

    /* renamed from: e */
    protected void mo499e(PointF pointF) {
        if (this.f960b.f764F == null || this.f960b.f759A < 0) {
            super.mo499e(pointF);
        } else {
            this.f960b.f764F.onItemLongPress(this.f960b, this.f960b.m1141g(this.f960b.f759A), this.f960b.f759A);
        }
    }

    /* renamed from: a */
    protected void mo492a(Canvas canvas) {
        this.f960b.mo449a(canvas);
        super.draw(canvas);
        this.f960b.mo452b(canvas);
    }

    /* renamed from: a */
    protected void mo491a(int i, int i2) {
        super.scrollTo(i, i2);
    }
}

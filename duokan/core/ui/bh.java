package com.duokan.core.ui;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;

public class bh extends ev {
    final /* synthetic */ ay b;

    public bh(ay ayVar) {
        this.b = ayVar;
        super(ayVar);
    }

    protected void a(ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState == ScrollState.IDLE && scrollState2 == ScrollState.DRAG) {
            this.b.o();
        }
    }

    protected void a(boolean z) {
        if (z) {
            this.b.k();
        }
        this.b.l();
    }

    protected void a(PointF pointF) {
        if (this.b.y == ScrollState.IDLE) {
            if ((this.b.E != null || this.b.F != null) && !this.b.p()) {
                Point point = new Point(Math.round(pointF.x), Math.round(pointF.y));
                b(point);
                this.b.A = this.b.a(point);
                if (this.b.A >= 0) {
                    this.b.a(this.b.A);
                }
            }
        }
    }

    protected void b(PointF pointF) {
        if (this.b.A >= 0) {
            this.b.o();
            this.b.A = -1;
        }
    }

    protected void c(PointF pointF) {
        this.b.o();
        this.b.A = -1;
    }

    protected void d(PointF pointF) {
        if (this.b.E == null || this.b.A < 0) {
            super.d(pointF);
            return;
        }
        this.b.a(new bi(this, this.b.A));
        this.b.A = -1;
    }

    protected void e(PointF pointF) {
        if (this.b.F == null || this.b.A < 0) {
            super.e(pointF);
        } else {
            this.b.F.a(this.b, this.b.g(this.b.A), this.b.A);
        }
    }

    protected void a(Canvas canvas) {
        this.b.a(canvas);
        super.draw(canvas);
        this.b.b(canvas);
    }

    protected void a(int i, int i2) {
        super.scrollTo(i, i2);
    }
}

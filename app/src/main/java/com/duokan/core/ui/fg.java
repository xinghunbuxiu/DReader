package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.Scrollable.ScrollState;

class fg implements du {
    final /* synthetic */ ff a;

    fg(ff ffVar) {
        this.a = ffVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        float f = 0.0f;
        if (this.a.a.s != ScrollState.DRAG && this.a.a.s != ScrollState.SEEK) {
            double b = dv.b(new PointF(0.0f, 0.0f), pointF2);
            if (this.a.a.Q() || this.a.a.R()) {
                this.a.a.v = a(b, (int) pointF2.x);
                this.a.a.w = b(b, (int) pointF2.y);
            } else {
                this.a.d.b(false);
                this.a.a.v = false;
                this.a.a.w = false;
            }
            if (this.a.a.v || this.a.a.w) {
                ScrollState e = this.a.a.s;
                this.a.d.a(0);
                this.a.d.b(0.0f);
                this.a.d.c(360.0f);
                this.a.a.a(ScrollState.DRAG);
                this.a.a.f(true);
                this.a.c(true);
                this.a.a.a(e, pointF.x + pointF2.x, pointF.y + pointF2.y);
            }
        } else if (this.a.a.s == ScrollState.SEEK) {
            this.a.a.h(Math.max(0.0f, Math.min((!this.a.a.t ? 0.0f : this.a.a.f((int) pointF2.x)) + this.a.a.aq(), 1.0f)), Math.max(0.0f, Math.min((!this.a.a.u ? 0.0f : this.a.a.g((int) pointF2.y)) + this.a.a.ar(), 1.0f)));
        } else if (this.a.a.s == ScrollState.DRAG) {
            ev evVar = this.a.a;
            float f2 = this.a.a.v ? pointF2.x : 0.0f;
            if (this.a.a.w) {
                f = pointF2.y;
            }
            evVar.a(f2, f);
        }
    }

    private boolean a(double d, int i) {
        if (!this.a.a.z) {
            return false;
        }
        if (!this.a.a.Q()) {
            return false;
        }
        if (!dv.a(d, -50.0d, 50.0d)) {
            return false;
        }
        if (i == 0) {
            return false;
        }
        if (this.a.a.S()) {
            return true;
        }
        if (i > 0 && !this.a.a.U()) {
            return true;
        }
        if (i >= 0 || this.a.a.V()) {
            return false;
        }
        return true;
    }

    private boolean b(double d, int i) {
        if (!this.a.a.y) {
            return false;
        }
        if (!this.a.a.R()) {
            return false;
        }
        if (!dv.a(d, 40.0d, 140.0d)) {
            return false;
        }
        if (i == 0) {
            return false;
        }
        if (this.a.a.T()) {
            return true;
        }
        if (i > 0 && !this.a.a.W()) {
            return true;
        }
        if (i >= 0 || this.a.a.X()) {
            return false;
        }
        return true;
    }
}

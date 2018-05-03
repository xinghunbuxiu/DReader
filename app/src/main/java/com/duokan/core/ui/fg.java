package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.Scrollable.ScrollState;

class fg implements du {
    /* renamed from: a */
    final /* synthetic */ ff f1252a;

    fg(ff ffVar) {
        this.f1252a = ffVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        float f = 0.0f;
        if (this.f1252a.f1249a.f952s != ScrollState.DRAG && this.f1252a.f1249a.f952s != ScrollState.SEEK) {
            double b = AnimUtils.m1928b(new PointF(0.0f, 0.0f), pointF2);
            if (this.f1252a.f1249a.m1465Q() || this.f1252a.f1249a.m1466R()) {
                this.f1252a.f1249a.f955v = m2052a(b, (int) pointF2.x);
                this.f1252a.f1249a.f956w = m2053b(b, (int) pointF2.y);
            } else {
                this.f1252a.f1251d.m1613b(false);
                this.f1252a.f1249a.f955v = false;
                this.f1252a.f1249a.f956w = false;
            }
            if (this.f1252a.f1249a.f955v || this.f1252a.f1249a.f956w) {
                ScrollState e = this.f1252a.f1249a.f952s;
                this.f1252a.f1251d.m1882a(0);
                this.f1252a.f1251d.m1885b(0.0f);
                this.f1252a.f1251d.m1887c(360.0f);
                this.f1252a.f1249a.m1416a(ScrollState.DRAG);
                this.f1252a.f1249a.m1432f(true);
                this.f1252a.m1617c(true);
                this.f1252a.f1249a.mo1760a(e, pointF.x + pointF2.x, pointF.y + pointF2.y);
            }
        } else if (this.f1252a.f1249a.f952s == ScrollState.SEEK) {
            this.f1252a.f1249a.m1549h(Math.max(0.0f, Math.min((!this.f1252a.f1249a.f953t ? 0.0f : this.f1252a.f1249a.m1431f((int) pointF2.x)) + this.f1252a.f1249a.aq(), 1.0f)), Math.max(0.0f, Math.min((!this.f1252a.f1249a.f954u ? 0.0f : this.f1252a.f1249a.m1434g((int) pointF2.y)) + this.f1252a.f1249a.ar(), 1.0f)));
        } else if (this.f1252a.f1249a.f952s == ScrollState.DRAG) {
            ev evVar = this.f1252a.f1249a;
            float f2 = this.f1252a.f1249a.f955v ? pointF2.x : 0.0f;
            if (this.f1252a.f1249a.f956w) {
                f = pointF2.y;
            }
            evVar.mo501a(f2, f);
        }
    }

    /* renamed from: a */
    private boolean m2052a(double d, int i) {
        if (!this.f1252a.f1249a.f959z) {
            return false;
        }
        if (!this.f1252a.f1249a.m1465Q()) {
            return false;
        }
        if (!AnimUtils.m1923a(d, -50.0d, 50.0d)) {
            return false;
        }
        if (i == 0) {
            return false;
        }
        if (this.f1252a.f1249a.m1467S()) {
            return true;
        }
        if (i > 0 && !this.f1252a.f1249a.m1469U()) {
            return true;
        }
        if (i >= 0 || this.f1252a.f1249a.m1470V()) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private boolean m2053b(double d, int i) {
        if (!this.f1252a.f1249a.f958y) {
            return false;
        }
        if (!this.f1252a.f1249a.m1466R()) {
            return false;
        }
        if (!AnimUtils.m1923a(d, 40.0d, 140.0d)) {
            return false;
        }
        if (i == 0) {
            return false;
        }
        if (this.f1252a.f1249a.m1468T()) {
            return true;
        }
        if (i > 0 && !this.f1252a.f1249a.m1471W()) {
            return true;
        }
        if (i >= 0 || this.f1252a.f1249a.m1472X()) {
            return false;
        }
        return true;
    }
}

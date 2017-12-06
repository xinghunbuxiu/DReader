package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.bu;
import com.duokan.core.ui.cb;
import com.duokan.core.ui.cd;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.OnTouchChangeListener;

import java.util.Iterator;

class lj extends er {
    final /* synthetic */ lb a;
    private float c = 0.0f;
    private float d = 1.0f;
    private PointF e = null;
    private final ct f = new ct();
    private final cd g = new cd();
    private final cb h = new cb();
    private final bu i = new bu();

    public lj(lb lbVar) {
        this.a = lbVar;
    }

    protected void a(View view, boolean z) {
        this.e = null;
        this.f.b(view, z);
        this.g.b(view, z);
        this.h.b(view, z);
        this.i.b(view, z);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        this.i.b(view, motionEvent, z, new lk(this));
        if (this.a.h == null) {
            d(view, motionEvent, z, esVar);
        } else if (!this.a.h.a()) {
        } else {
            if (motionEvent.getAction() == 1) {
                this.c = 0.0f;
                this.d = 1.0f;
                this.a.j();
                return;
            }
            PointF pointF = new PointF(0.0f, 0.0f);
            float[] fArr = new float[]{0.0f};
            float[] fArr2 = new float[]{1.0f};
            this.h.b(view, motionEvent, z, new ll(this, fArr, pointF));
            this.g.b(view, motionEvent, z, new lm(this, fArr2, pointF));
            if (Float.compare(fArr[0], 0.0f) != 0 || ((double) Float.compare(fArr2[0], 0.0f)) != 1.0d) {
                this.c = fArr[0] + this.c;
                this.d *= fArr2[0];
                if (this.e == null) {
                    this.e = new PointF(pointF.x, pointF.y);
                    this.a.a(new PointF(0.0f, 0.0f), this.c, this.d);
                    return;
                }
                pointF.offset(-this.e.x, -this.e.y);
                this.a.a(pointF, this.c, this.d);
            }
        }
    }

    private boolean d(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        boolean z2 = true;
        if (motionEvent.getPointerCount() > 2) {
            b(false);
            return false;
        }
        fu a;
        while (motionEvent.getPointerCount() != 2) {
            fu fuVar;
            int i;
            if (motionEvent.getPointerCount() == 1) {
                boolean[] zArr = new boolean[]{false};
                this.f.b(view, motionEvent, z, new ln(this, zArr));
                if (!zArr[0]) {
                    return false;
                }
                a = a(motionEvent.getX(0), motionEvent.getY(0));
                if (a == null || !a.c()) {
                    return false;
                }
                fuVar = a;
                i = 1;
                if (fuVar != null) {
                    this.a.f(fuVar);
                    if (i != 0) {
                        this.a.k();
                    }
                }
                if (fuVar == null) {
                    z2 = false;
                }
                return z2;
            }
        }
        if (motionEvent.getActionMasked() == 5) {
            a = a(motionEvent.getX(0), motionEvent.getY(0));
            if (a != null && a.a() && a == a(motionEvent.getX(1), motionEvent.getY(1))) {
                fuVar = a;
                i = false;
                if (fuVar != null) {
                    this.a.f(fuVar);
                    if (i != 0) {
                        this.a.k();
                    }
                }
                if (fuVar == null) {
                    z2 = false;
                }
                return z2;
            }
        }
        b(false);
        return false;
    }

    private fu a(float f, float f2) {
        Iterator it = this.a.f.iterator();
        while (it.hasNext()) {
            fu fuVar = (fu) it.next();
            if (fuVar.getOriginBounds().contains((int) f, (int) f2)) {
                return fuVar;
            }
        }
        return null;
    }
}

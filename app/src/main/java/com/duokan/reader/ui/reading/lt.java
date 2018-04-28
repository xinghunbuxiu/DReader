package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.bu;
import com.duokan.core.ui.cb;
import com.duokan.core.ui.cd;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import java.util.Iterator;

class lt extends er {
    /* renamed from: a */
    final /* synthetic */ ll f10583a;
    /* renamed from: c */
    private float f10584c = 0.0f;
    /* renamed from: d */
    private float f10585d = 1.0f;
    /* renamed from: e */
    private PointF f10586e = null;
    /* renamed from: f */
    private final ct f10587f = new ct();
    /* renamed from: g */
    private final cd f10588g = new cd();
    /* renamed from: h */
    private final cb f10589h = new cb();
    /* renamed from: i */
    private final bu f10590i = new bu();

    public lt(ll llVar) {
        this.f10583a = llVar;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f10586e = null;
        this.f10587f.m1612b(view, z);
        this.f10588g.m1612b(view, z);
        this.f10589h.m1612b(view, z);
        this.f10590i.m1612b(view, z);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        this.f10590i.m1611b(view, motionEvent, z, new lu(this));
        if (this.f10583a.f10256h == null) {
            m14618d(view, motionEvent, z, esVar);
        } else if (!this.f10583a.f10256h.mo2467a()) {
        } else {
            if (motionEvent.getAction() == 1) {
                this.f10584c = 0.0f;
                this.f10585d = 1.0f;
                this.f10583a.m14239j();
                return;
            }
            PointF pointF = new PointF(0.0f, 0.0f);
            float[] fArr = new float[]{0.0f};
            float[] fArr2 = new float[]{1.0f};
            this.f10589h.m1611b(view, motionEvent, z, new lv(this, fArr, pointF));
            this.f10588g.m1611b(view, motionEvent, z, new lw(this, fArr2, pointF));
            if (Float.compare(fArr[0], 0.0f) != 0 || ((double) Float.compare(fArr2[0], 0.0f)) != 1.0d) {
                this.f10584c = fArr[0] + this.f10584c;
                this.f10585d *= fArr2[0];
                if (this.f10586e == null) {
                    this.f10586e = new PointF(pointF.x, pointF.y);
                    this.f10583a.m14229a(new PointF(0.0f, 0.0f), this.f10584c, this.f10585d);
                    return;
                }
                pointF.offset(-this.f10586e.x, -this.f10586e.y);
                this.f10583a.m14229a(pointF, this.f10584c, this.f10585d);
            }
        }
    }

    /* renamed from: d */
    private boolean m14618d(View view, MotionEvent motionEvent, boolean z, es esVar) {
        boolean z2 = true;
        if (motionEvent.getPointerCount() > 2) {
            m1613b(false);
            return false;
        }
        while (motionEvent.getPointerCount() != 2) {
            fz a;
            fz fzVar;
            int i;
            if (motionEvent.getPointerCount() == 1) {
                boolean[] zArr = new boolean[]{false};
                this.f10587f.m1611b(view, motionEvent, z, new lx(this, zArr));
                if (!zArr[0]) {
                    return false;
                }
                a = m14616a(motionEvent.getX(0), motionEvent.getY(0));
                if (a == null || !a.mo2469c()) {
                    return false;
                }
                fzVar = a;
                i = 1;
                if (fzVar != null) {
                    this.f10583a.m14251f(fzVar);
                    if (i != 0) {
                        this.f10583a.m14240k();
                    }
                }
                if (fzVar == null) {
                    z2 = false;
                }
                return z2;
            }
        }
        if (motionEvent.getActionMasked() == 5) {
            a = m14616a(motionEvent.getX(0), motionEvent.getY(0));
            if (a != null && a.mo2467a() && a == m14616a(motionEvent.getX(1), motionEvent.getY(1))) {
                fzVar = a;
                i = false;
                if (fzVar != null) {
                    this.f10583a.m14251f(fzVar);
                    if (i != 0) {
                        this.f10583a.m14240k();
                    }
                }
                if (fzVar == null) {
                    z2 = false;
                }
                return z2;
            }
        }
        m1613b(false);
        return false;
    }

    /* renamed from: a */
    private fz m14616a(float f, float f2) {
        Iterator it = this.f10583a.f10254f.iterator();
        while (it.hasNext()) {
            fz fzVar = (fz) it.next();
            if (fzVar.getOriginBounds().contains((int) f, (int) f2)) {
                return fzVar;
            }
        }
        return null;
    }
}

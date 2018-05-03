package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.as;

class aeu extends er {
    /* renamed from: a */
    final /* synthetic */ adz f9598a;
    /* renamed from: c */
    private final dt f9599c = new dt();

    public aeu(adz adz) {
        this.f9598a = adz;
        this.f9599c.m1882a(AnimUtils.getScaledTouchSlop(adz.getContext()));
        this.f9599c.m1885b(45.0f);
        this.f9599c.m1887c(135.0f);
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f9599c.m1612b(view, z);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (this.f9598a.f9552l == null && !this.f9598a.m13449e()) {
            m1613b(false);
        } else if (this.f9598a.f9552l != null && motionEvent.getActionMasked() == 1) {
            this.f9598a.m13429c(this.f9598a.f9552l.f9605b);
            this.f9598a.f9552l = null;
            this.f9598a.f9543c.invalidate();
        } else if (this.f9598a.f9541a.mo2004U() == PageAnimationMode.VSCROLL) {
            m13475e(view, motionEvent, z, esVar);
        } else {
            m13473d(view, motionEvent, z, esVar);
        }
    }

    /* renamed from: d */
    private void m13473d(View view, MotionEvent motionEvent, boolean z, es esVar) {
        as aa = this.f9598a.f9541a.aa();
        if (aa != null && aa.mo1284G()) {
            if (this.f9598a.f9552l != null && this.f9598a.f9552l.f9604a == null) {
                this.f9598a.f9552l.f9604a = this.f9598a.m13416a(aa);
                afc c;
                Rect d;
                if (this.f9598a.f9552l.f9605b.mo1188a(this.f9598a.f9552l.m13482c().f9622b)) {
                    c = this.f9598a.f9552l.m13482c();
                    d = aa.mo1311d(c.f9622b);
                    this.f9598a.f9552l.f9605b = (C0897d) c.f9622b.mo1198g();
                    this.f9598a.f9552l.f9606c.x = d.centerX();
                    this.f9598a.f9552l.f9606c.y = d.top;
                } else if (this.f9598a.f9552l.f9605b.mo1190c(this.f9598a.f9552l.m13483d().f9622b)) {
                    c = this.f9598a.f9552l.m13483d();
                    d = aa.mo1311d(c.f9622b);
                    this.f9598a.f9552l.f9605b = (C0897d) c.f9622b.mo1198g();
                    this.f9598a.f9552l.f9606c.x = d.centerX();
                    this.f9598a.f9552l.f9606c.y = d.bottom;
                } else {
                    Rect d2 = aa.mo1311d(this.f9598a.f9552l.m13481b().f9622b);
                    this.f9598a.f9552l.f9606c.x = d2.centerX();
                    this.f9598a.f9552l.f9606c.y = d2.top;
                }
                this.f9598a.f9552l.f9607d.set(this.f9598a.f9552l.f9606c.x, this.f9598a.f9552l.f9606c.y);
            }
            this.f9599c.m1611b(view, motionEvent, z, new aev(this, aa));
        }
    }

    /* renamed from: e */
    private void m13475e(View view, MotionEvent motionEvent, boolean z, es esVar) {
        int i;
        int i2 = 0;
        gx[] ay = this.f9598a.f9541a.ay();
        for (gx i3 : ay) {
            if (!i3.m14303i()) {
                i = 0;
                break;
            }
        }
        i = 1;
        if (i != 0 && ay.length >= 1) {
            this.f9598a.f9541a.mo2039a(ay);
            as[] asVarArr = new as[ay.length];
            while (i2 < asVarArr.length) {
                asVarArr[i2] = ay[i2].getPageDrawable();
                i2++;
            }
            if (this.f9598a.f9552l != null && this.f9598a.f9552l.f9604a == null) {
                this.f9598a.f9552l.f9604a = this.f9598a.m13419a(asVarArr);
                if (this.f9598a.f9552l.f9605b.mo1188a(this.f9598a.f9552l.m13482c().f9622b)) {
                    this.f9598a.f9552l.f9605b = (C0897d) this.f9598a.f9552l.m13482c().f9622b.mo1198g();
                } else if (this.f9598a.f9552l.f9605b.mo1190c(this.f9598a.f9552l.m13483d().f9622b)) {
                    this.f9598a.f9552l.f9605b = (C0897d) this.f9598a.f9552l.m13483d().f9622b.mo1198g();
                }
            }
            this.f9599c.m1611b(view, motionEvent, z, new aew(this, asVarArr));
        }
    }
}

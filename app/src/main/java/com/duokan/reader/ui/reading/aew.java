package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import com.duokan.core.ui.du;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.er;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.as;

class aew implements du {
    /* renamed from: a */
    final /* synthetic */ as[] f9602a;
    /* renamed from: b */
    final /* synthetic */ aeu f9603b;

    aew(aeu aeu, as[] asVarArr) {
        this.f9603b = aeu;
        this.f9602a = asVarArr;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (this.f9603b.f9598a.f9552l != null) {
            this.f9603b.f9598a.f9541a.scrollBy(0, (int) (-pointF2.y));
            int a = this.f9603b.f9598a.f9552l.m13480a();
            Rect c = this.f9603b.f9598a.f9541a.mo2124c(this.f9603b.f9598a.f9552l.m13481b().f9622b);
            aex aex;
            if (this.f9603b.f9598a.f9552l.f9606c.y >= c.bottom + AnimUtils.getScaledPagingTouchSlop(this.f9603b.f9598a.getContext())) {
                if (a < this.f9603b.f9598a.f9552l.f9604a.length - 1) {
                    this.f9603b.f9598a.f9552l.f9605b = (C0897d) this.f9603b.f9598a.f9552l.f9604a[a + 1].f9622b.mo1198g();
                } else {
                    aex = new aex();
                    aex.f9605b = (C0897d) this.f9603b.f9598a.f9552l.m13483d().f9622b.mo1198g();
                    aex.f9606c.set(this.f9603b.f9598a.f9552l.f9606c.x, this.f9603b.f9598a.f9552l.f9606c.y);
                    aex.f9607d.set(this.f9603b.f9598a.f9552l.f9607d.x, this.f9603b.f9598a.f9552l.f9607d.y);
                    this.f9603b.f9598a.f9552l = aex;
                    return;
                }
            } else if (this.f9603b.f9598a.f9552l.f9606c.y < c.top - AnimUtils.getScaledPagingTouchSlop(this.f9603b.f9598a.getContext())) {
                if (a > 0) {
                    this.f9603b.f9598a.f9552l.f9605b = (C0897d) this.f9603b.f9598a.f9552l.f9604a[a - 1].f9622b.mo1198g();
                } else {
                    aex = new aex();
                    aex.f9605b = (C0897d) this.f9603b.f9598a.f9552l.m13482c().f9622b.mo1198g();
                    aex.f9606c.set(this.f9603b.f9598a.f9552l.f9606c.x, this.f9603b.f9598a.f9552l.f9606c.y);
                    aex.f9607d.set(this.f9603b.f9598a.f9552l.f9607d.x, this.f9603b.f9598a.f9552l.f9607d.y);
                    this.f9603b.f9598a.f9552l = aex;
                    return;
                }
            }
        } else if (!this.f9603b.f9598a.f9549i.f9613b.isEmpty()) {
            this.f9603b.f9598a.m13448d();
            this.f9603b.f9598a.f9552l = new aex();
            this.f9603b.f9598a.f9552l.f9604a = this.f9603b.f9598a.m13419a(this.f9602a);
            afc afc = (afc) this.f9603b.f9598a.f9549i.f9613b.getFirst();
            this.f9603b.f9598a.f9552l.f9605b = (C0897d) this.f9603b.f9598a.f9552l.m13482c().f9622b.mo1198g();
            for (int i = 0; i < this.f9603b.f9598a.f9552l.f9604a.length; i++) {
                if (afc.f9622b.m5812a(this.f9603b.f9598a.f9552l.f9604a[i].f9622b.mo1198g())) {
                    this.f9603b.f9598a.f9552l.f9605b = (C0897d) this.f9603b.f9598a.f9552l.f9604a[i].f9622b.mo1198g();
                    break;
                }
            }
            Rect c2 = this.f9603b.f9598a.f9541a.mo2124c(afc.f9622b);
            this.f9603b.f9598a.f9552l.f9606c.x = c2.centerX();
            this.f9603b.f9598a.f9552l.f9606c.y = c2.centerY();
            this.f9603b.f9598a.f9552l.f9607d.set(this.f9603b.f9598a.f9552l.f9606c.x, this.f9603b.f9598a.f9552l.f9606c.y);
            this.f9603b.m1617c(true);
            this.f9603b.m1620d(true);
        } else {
            return;
        }
        this.f9603b.f9598a.f9541a.setActiveColorText(this.f9603b.f9598a.f9552l.m13481b().f9622b);
        this.f9603b.f9598a.f9543c.invalidate();
    }
}

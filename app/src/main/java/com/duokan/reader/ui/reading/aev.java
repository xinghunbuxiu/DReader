package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import com.duokan.core.ui.du;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.er;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.C0941i;
import com.duokan.reader.domain.document.as;

class aev implements du {
    /* renamed from: a */
    final /* synthetic */ as f9600a;
    /* renamed from: b */
    final /* synthetic */ aeu f9601b;

    aev(aeu aeu, as asVar) {
        this.f9601b = aeu;
        this.f9600a = asVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        Rect d;
        if (this.f9601b.f9598a.f9552l != null) {
            Point point = this.f9601b.f9598a.f9552l.f9606c;
            point.y += (int) pointF2.y;
            if (Math.abs(this.f9601b.f9598a.f9552l.f9607d.y - this.f9601b.f9598a.f9552l.f9606c.y) > dv.getScaledTouchSlop(this.f9601b.f9598a.getContext())) {
                this.f9601b.f9598a.f9552l.f9607d.set(this.f9601b.f9598a.f9552l.f9606c.x, this.f9601b.f9598a.f9552l.f9606c.y);
                int a = this.f9601b.f9598a.f9552l.m13480a();
                C0897d c0897d;
                aex aex;
                if (a == this.f9601b.f9598a.f9552l.f9604a.length - 1 && this.f9601b.f9598a.f9552l.f9606c.y >= this.f9600a.mo1311d(this.f9601b.f9598a.f9552l.m13483d().f9622b).bottom + dv.getScaledPagingTouchSlop(this.f9601b.f9598a.getContext())) {
                    c0897d = (C0897d) this.f9601b.f9598a.f9552l.m13483d().f9622b.mo1198g();
                    aex = new aex();
                    aex.f9605b = c0897d;
                    this.f9601b.f9598a.f9552l = aex;
                    this.f9601b.f9598a.f9541a.mo2179u();
                    return;
                } else if (a != 0 || this.f9601b.f9598a.f9552l.f9606c.y >= this.f9600a.mo1311d(this.f9601b.f9598a.f9552l.m13482c().f9622b).top - dv.getScaledPagingTouchSlop(this.f9601b.f9598a.getContext())) {
                    as asVar;
                    if (this.f9600a instanceof C0941i) {
                        as b;
                        C0941i c0941i = (C0941i) this.f9600a;
                        if (c0941i.mo1435d().contains(this.f9601b.f9598a.f9552l.f9606c.x, this.f9601b.f9598a.f9552l.f9606c.y)) {
                            b = c0941i.mo1305b();
                        } else {
                            b = c0941i.mo1434c();
                        }
                        asVar = b;
                    } else {
                        asVar = this.f9600a;
                    }
                    d = asVar.mo1311d(this.f9601b.f9598a.f9552l.f9604a[a].f9622b);
                    afc afc;
                    if (pointF2.y < 0.0f || a >= this.f9601b.f9598a.f9552l.f9604a.length - 1) {
                        if (pointF2.y < 0.0f && a > 0 && this.f9601b.f9598a.f9552l.f9606c.y < d.top) {
                            afc = this.f9601b.f9598a.f9552l.f9604a[a - 1];
                            this.f9601b.f9598a.f9552l.f9605b = (C0897d) afc.f9622b.mo1198g();
                            if (!asVar.mo1332l().m5814b(afc.f9622b)) {
                                point = this.f9600a.mo1321g(afc.f9622b);
                                this.f9601b.f9598a.f9552l.f9606c.x = point.x;
                                this.f9601b.f9598a.f9552l.f9606c.y = point.y;
                            }
                        }
                    } else if (this.f9601b.f9598a.f9552l.f9606c.y >= d.bottom) {
                        afc = this.f9601b.f9598a.f9552l.f9604a[a + 1];
                        this.f9601b.f9598a.f9552l.f9605b = (C0897d) afc.f9622b.mo1198g();
                        if (!asVar.mo1332l().m5814b(afc.f9622b)) {
                            point = this.f9600a.mo1318f(afc.f9622b);
                            this.f9601b.f9598a.f9552l.f9606c.x = point.x;
                            this.f9601b.f9598a.f9552l.f9606c.y = point.y;
                        }
                    }
                } else {
                    c0897d = (C0897d) this.f9601b.f9598a.f9552l.m13482c().f9622b.mo1198g();
                    aex = new aex();
                    aex.f9605b = c0897d;
                    this.f9601b.f9598a.f9552l = aex;
                    this.f9601b.f9598a.f9541a.mo2178t();
                    return;
                }
            }
        } else if (!this.f9601b.f9598a.f9549i.f9613b.isEmpty()) {
            this.f9601b.f9598a.m13448d();
            this.f9601b.f9598a.f9552l = new aex();
            this.f9601b.f9598a.f9552l.f9604a = this.f9601b.f9598a.m13416a(this.f9600a);
            afc afc2 = (afc) this.f9601b.f9598a.f9549i.f9613b.getFirst();
            if (this.f9600a.mo1332l().m5814b(afc2.f9622b)) {
                int i;
                this.f9601b.f9598a.f9552l.f9605b = (C0897d) this.f9601b.f9598a.f9552l.m13482c().f9622b.mo1198g();
                for (i = 0; i < this.f9601b.f9598a.f9552l.f9604a.length; i++) {
                    if (afc2.f9622b.m5812a(this.f9601b.f9598a.f9552l.f9604a[i].f9622b.mo1198g())) {
                        this.f9601b.f9598a.f9552l.f9605b = (C0897d) this.f9601b.f9598a.f9552l.f9604a[i].f9622b.mo1198g();
                        break;
                    }
                }
                i = this.f9601b.f9598a.f9542b.mo1245k().f4335f;
                d = this.f9600a.mo1311d(afc2.f9622b);
                if (pointF2.y >= 0.0f) {
                    this.f9601b.f9598a.f9552l.f9606c.x = d.centerX();
                    this.f9601b.f9598a.f9552l.f9606c.y = d.bottom - i;
                } else {
                    this.f9601b.f9598a.f9552l.f9606c.x = d.centerX();
                    this.f9601b.f9598a.f9552l.f9606c.y = d.top + i;
                }
            } else if (pointF2.y >= 0.0f) {
                afc2 = this.f9601b.f9598a.f9552l.m13482c();
                r1 = this.f9600a.mo1311d(afc2.f9622b);
                this.f9601b.f9598a.f9552l.f9605b = (C0897d) afc2.f9622b.mo1198g();
                this.f9601b.f9598a.f9552l.f9606c.x = r1.centerX();
                this.f9601b.f9598a.f9552l.f9606c.y = r1.top;
            } else {
                afc2 = this.f9601b.f9598a.f9552l.m13483d();
                r1 = this.f9600a.mo1311d(afc2.f9622b);
                this.f9601b.f9598a.f9552l.f9605b = (C0897d) afc2.f9622b.mo1198g();
                this.f9601b.f9598a.f9552l.f9606c.x = r1.centerX();
                this.f9601b.f9598a.f9552l.f9606c.y = r1.bottom;
            }
            this.f9601b.f9598a.f9552l.f9607d.set(this.f9601b.f9598a.f9552l.f9606c.x, this.f9601b.f9598a.f9552l.f9606c.y);
            this.f9601b.m1617c(true);
            this.f9601b.m1620d(true);
        } else {
            return;
        }
        this.f9601b.f9598a.f9541a.setActiveColorText(this.f9601b.f9598a.f9552l.m13481b().f9622b);
        this.f9601b.f9598a.f9543c.invalidate();
    }
}

package com.duokan.reader.ui.reading.p054a;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import com.duokan.core.ui.bw;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.au;

/* renamed from: com.duokan.reader.ui.reading.a.s */
class C1438s implements bw {
    /* renamed from: a */
    final /* synthetic */ C1439t f9235a;
    /* renamed from: b */
    final /* synthetic */ C1437r f9236b;

    C1438s(C1437r c1437r, C1439t c1439t) {
        this.f9236b = c1437r;
        this.f9235a = c1439t;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo521a(View view, PointF pointF) {
        au c;
        as aa = this.f9236b.f9233a.aa();
        int e = aa.mo1314e(new Point((int) pointF.x, (int) pointF.y));
        if (e >= 0) {
            ac k = aa.mo1329k(e);
            Rect l = aa.mo1331l(e);
            Rect rect = new Rect(k.mo1385b());
            rect.offset(l.left, l.top);
            if (rect.contains((int) pointF.x, (int) pointF.y)) {
                this.f9235a.mo2496a(k.mo1386b(k.mo1381a()), rect);
                this.f9236b.m1620d(true);
                this.f9236b.m1617c(true);
                return;
            }
        }
        e = aa.mo1306c(new Point((int) pointF.x, (int) pointF.y));
        if (e >= 0) {
            c = aa.mo1308c(e);
            l = aa.mo1322g(e);
            if (!this.f9236b.f9233a.mo1992G().ak()) {
                this.f9235a.mo2496a(c, l);
                this.f9236b.m1620d(true);
                this.f9236b.m1617c(true);
                return;
            }
        }
        e = aa.mo1317f(new Point((int) pointF.x, (int) pointF.y));
        if (e >= 0) {
            c = aa.mo1312d(e);
            Rect h = aa.mo1325h(e);
            if (!this.f9236b.f9233a.mo1992G().ak()) {
                this.f9235a.mo2496a(c, h);
                this.f9236b.m1620d(true);
                this.f9236b.m1617c(true);
            }
        }
    }
}

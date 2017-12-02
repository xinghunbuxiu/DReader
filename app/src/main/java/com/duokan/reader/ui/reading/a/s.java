package com.duokan.reader.ui.reading.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.ui.bw;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.au;

class s implements bw {
    final /* synthetic */ t a;
    final /* synthetic */ r b;

    s(r rVar, t tVar) {
        this.b = rVar;
        this.a = tVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(View view, PointF pointF) {
        au c;
        as aa = this.b.a.aa();
        int e = aa.e(new Point((int) pointF.x, (int) pointF.y));
        if (e >= 0) {
            ac k = aa.k(e);
            Rect l = aa.l(e);
            Rect rect = new Rect(k.b());
            rect.offset(l.left, l.top);
            if (rect.contains((int) pointF.x, (int) pointF.y)) {
                this.a.a(k.b(k.a()), rect);
                this.b.d(true);
                this.b.c(true);
                return;
            }
        }
        e = aa.c(new Point((int) pointF.x, (int) pointF.y));
        if (e >= 0) {
            c = aa.c(e);
            l = aa.g(e);
            if (!this.b.a.G().ai()) {
                this.a.a(c, l);
                this.b.d(true);
                this.b.c(true);
                return;
            }
        }
        e = aa.f(new Point((int) pointF.x, (int) pointF.y));
        if (e >= 0) {
            c = aa.d(e);
            Rect h = aa.h(e);
            if (!this.b.a.G().ai()) {
                this.a.a(c, h);
                this.b.d(true);
                this.b.c(true);
            }
        }
    }
}

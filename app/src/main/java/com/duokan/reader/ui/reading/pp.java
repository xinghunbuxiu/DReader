package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.duokan.core.ui.dl;
import com.duokan.core.ui.dv;
import org.apache.http.HttpStatus;

class pp implements OnPreDrawListener {
    /* renamed from: a */
    final /* synthetic */ Point f10806a;
    /* renamed from: b */
    final /* synthetic */ po f10807b;

    pp(po poVar, Point point) {
        this.f10807b = poVar;
        this.f10806a = point;
    }

    public boolean onPreDraw() {
        Point point = new Point(0, 0);
        dv.m1945c(point, this.f10807b.f10802a);
        Point point2 = new Point(this.f10806a.x - point.x, this.f10806a.y - point.y);
        dv.m1896a(point2, this.f10807b.f10804c);
        this.f10807b.f10804c.m1354a(this.f10807b.f10804c.getScrollX() - point2.x, this.f10807b.f10804c.getScrollY() - point2.y);
        this.f10807b.f10804c.setThumbEnabled(false);
        this.f10807b.f10804c.n_();
        this.f10807b.f10803b.m1832a(this.f10807b.f10804c, new dl(), HttpStatus.SC_INTERNAL_SERVER_ERROR, new pq(this), null);
        this.f10807b.f10803b.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    }
}

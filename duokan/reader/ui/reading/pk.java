package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.ViewTreeObserver.OnPreDrawListener;

import com.duokan.core.ui.UTools;

import org.apache.http.HttpStatus;

class pk implements OnPreDrawListener {
    final /* synthetic */ Point a;
    final /* synthetic */ pj b;

    pk(pj pjVar, Point point) {
        this.b = pjVar;
        this.a = point;
    }

    public boolean onPreDraw() {
        Point point = new Point(0, 0);
        UTools.showAnimation(point, this.b.a);
        Point point2 = new Point(this.a.x - point.x, this.a.y - point.y);
        UTools.addAnimation(point2, this.b.c);
        this.b.c.a(this.b.c.getScrollX() - point2.x, this.b.c.getScrollY() - point2.y);
        this.b.c.setThumbEnabled(false);
        this.b.c.b(0.0f, 0.0f, 1.0f, null, null);
        this.b.b.a(this.b.e, this.b.f, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
        this.b.b.a(this.b.g, this.b.h, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
        this.b.b.a(this.b.c, this.b.i, HttpStatus.SC_INTERNAL_SERVER_ERROR, new pl(this), null);
        this.b.b.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    }
}

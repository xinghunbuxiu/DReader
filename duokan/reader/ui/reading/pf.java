package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.ViewTreeObserver.OnPreDrawListener;

import com.duokan.core.ui.UTools;
import com.duokan.core.ui.dl;

import org.apache.http.HttpStatus;

class pf implements OnPreDrawListener {
    final /* synthetic */ Point a;
    final /* synthetic */ pe b;

    pf(pe peVar, Point point) {
        this.b = peVar;
        this.a = point;
    }

    public boolean onPreDraw() {
        Point point = new Point(0, 0);
        UTools.showAnimation(point, this.b.a);
        Point point2 = new Point(this.a.x - point.x, this.a.y - point.y);
        UTools.addAnimation(point2, this.b.c);
        this.b.c.a(this.b.c.getScrollX() - point2.x, this.b.c.getScrollY() - point2.y);
        this.b.c.setThumbEnabled(false);
        this.b.c.m_();
        this.b.b.a(this.b.c, new dl(), HttpStatus.SC_INTERNAL_SERVER_ERROR, new pg(this), null);
        this.b.b.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    }
}

package com.duokan.reader.ui.reading;

import android.graphics.Point;

import com.duokan.core.ui.UTools;

class gd implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ Point b;
    final /* synthetic */ fy c;

    gd(fy fyVar, boolean z, Point point) {
        this.c = fyVar;
        this.a = z;
        this.b = point;
    }

    public void run() {
        if (this.a) {
            Point point = new Point(0, 0);
            UTools.showAnimation(point, this.c.c);
            Point point2 = new Point(this.b.x - point.x, this.b.y - point.y);
            UTools.addAnimation(point2, this.c);
            this.c.a(this.c.getScrollX() - point2.x, this.c.getScrollY() - point2.y);
            this.c.b = new Point(this.c.getScrollX() + (this.c.getWidth() / 2), this.c.getScrollY() + (this.c.getHeight() / 2));
            UTools.getTouchPoint(this.c.b, this.c, this.c.c);
            this.c.a((float) (this.c.c.getWidth() / 2), (float) (this.c.c.getHeight() / 2), this.c.i(), new ge(this), null);
            return;
        }
        this.c.setMinZoomFactor(this.c.i());
        this.c.b((float) (this.c.c.getWidth() / 2), (float) (this.c.c.getHeight() / 2), this.c.i());
    }
}

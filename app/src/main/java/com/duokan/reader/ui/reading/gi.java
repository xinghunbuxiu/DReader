package com.duokan.reader.ui.reading;

import android.graphics.Point;
import com.duokan.core.ui.dv;

class gi implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f10239a;
    /* renamed from: b */
    final /* synthetic */ Point f10240b;
    /* renamed from: c */
    final /* synthetic */ gd f10241c;

    gi(gd gdVar, boolean z, Point point) {
        this.f10241c = gdVar;
        this.f10239a = z;
        this.f10240b = point;
    }

    public void run() {
        if (this.f10239a) {
            Point point = new Point(0, 0);
            dv.m1945c(point, this.f10241c.f10223c);
            Point point2 = new Point(this.f10240b.x - point.x, this.f10240b.y - point.y);
            dv.m1896a(point2, this.f10241c);
            this.f10241c.m1354a(this.f10241c.getScrollX() - point2.x, this.f10241c.getScrollY() - point2.y);
            this.f10241c.f10222b = new Point(this.f10241c.getScrollX() + (this.f10241c.getWidth() / 2), this.f10241c.getScrollY() + (this.f10241c.getHeight() / 2));
            dv.m1897a(this.f10241c.f10222b, this.f10241c, this.f10241c.f10223c);
            this.f10241c.m1353a((float) (this.f10241c.f10223c.getWidth() / 2), (float) (this.f10241c.f10223c.getHeight() / 2), this.f10241c.mo2421i(), new gj(this), null);
            return;
        }
        this.f10241c.setMinZoomFactor(this.f10241c.mo2421i());
        this.f10241c.m1357b((float) (this.f10241c.f10223c.getWidth() / 2), (float) (this.f10241c.f10223c.getHeight() / 2), this.f10241c.mo2421i());
    }
}

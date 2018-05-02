package com.duokan.reader.ui.bookshelf;

import android.graphics.PointF;
import android.graphics.RectF;

import com.duokan.core.ui.UTools;

class cf implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ bz b;

    cf(bz bzVar, int i) {
        this.b = bzVar;
        this.a = i;
    }

    public void run() {
        RectF rectF = (RectF) UTools.h.getRect();
        PointF pointF = (PointF) UTools.f.getRect();
        this.b.a(rectF, this.a);
        pointF.set(rectF.centerX(), rectF.centerY());
        this.b.h.a(pointF);
        UTools.f.getRect(pointF);
        UTools.h.getRect(rectF);
        this.b.n = this.a;
        this.b.m = this.b.j.getContentScrollY();
        this.b.j.a(this.b.k, this.a);
    }
}

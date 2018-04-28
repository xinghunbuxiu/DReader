package com.duokan.reader.ui.bookshelf;

import android.graphics.PointF;
import android.graphics.RectF;
import com.duokan.core.ui.dv;

class ck implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f6275a;
    /* renamed from: b */
    final /* synthetic */ ce f6276b;

    ck(ce ceVar, int i) {
        this.f6276b = ceVar;
        this.f6275a = i;
    }

    public void run() {
        RectF rectF = (RectF) dv.f1199h.addAnimation();
        PointF pointF = (PointF) dv.f1197f.addAnimation();
        this.f6276b.m9361a(rectF, this.f6275a);
        pointF.set(rectF.centerX(), rectF.centerY());
        this.f6276b.f6256h.m9426a(pointF);
        dv.f1197f.clearAnimation(pointF);
        dv.f1199h.clearAnimation(rectF);
        this.f6276b.f6262n = this.f6275a;
        this.f6276b.f6261m = this.f6276b.f6258j.getContentScrollY();
        this.f6276b.f6258j.mo1666a(this.f6276b.f6259k, this.f6275a);
    }
}

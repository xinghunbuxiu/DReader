package com.duokan.reader.ui.bookshelf;

import android.graphics.PointF;
import android.graphics.Rect;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.an;

class co implements Runnable {
    /* renamed from: a */
    final /* synthetic */ aa f6285a;
    /* renamed from: b */
    final /* synthetic */ an f6286b;
    /* renamed from: c */
    final /* synthetic */ ce f6287c;

    co(ce ceVar, aa aaVar, an anVar) {
        this.f6287c = ceVar;
        this.f6285a = aaVar;
        this.f6286b = anVar;
    }

    public void run() {
        this.f6287c.f6267s = true;
        this.f6287c.f6258j = this.f6287c.f6250a.f6191b;
        this.f6287c.f6258j.mo1668a(this.f6287c.f6259k, true);
        this.f6287c.f6262n = 0;
        this.f6287c.f6261m = 0;
        Rect a = this.f6287c.f6258j.mo1661a(0);
        PointF pointF = (PointF) dv.f1197f.addAnimation();
        pointF.set((float) a.centerX(), (float) a.centerY());
        this.f6287c.f6256h.m9426a(pointF);
        dv.f1197f.clearAnimation(pointF);
        this.f6287c.m9367a(300, new cp(this));
    }
}

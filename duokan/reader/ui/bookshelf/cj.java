package com.duokan.reader.ui.bookshelf;

import android.graphics.PointF;
import android.graphics.Rect;

import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.an;

class cj implements Runnable {
    final /* synthetic */ aa a;
    final /* synthetic */ an b;
    final /* synthetic */ bz c;

    cj(bz bzVar, aa aaVar, an anVar) {
        this.c = bzVar;
        this.a = aaVar;
        this.b = anVar;
    }

    public void run() {
        this.c.s = true;
        this.c.j = this.c.a.b;
        this.c.j.a(this.c.k, true);
        this.c.n = 0;
        this.c.m = 0;
        Rect a = this.c.j.a(0);
        PointF pointF = (PointF) UTools.f.getRect();
        pointF.set((float) a.centerX(), (float) a.centerY());
        this.c.h.a(pointF);
        UTools.f.getRect(pointF);
        this.c.a(300, new ck(this));
    }
}

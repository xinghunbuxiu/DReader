package com.duokan.reader.ui.reading;

import android.graphics.Point;

import com.duokan.core.app.s;
import com.duokan.core.ui.*;
import com.duokan.core.ui.ZoomView;
import com.duokan.core.ui.di;
import com.duokan.core.ui.dl;
import com.duokan.core.ui.dv;

do;

class pe implements s {
    final /* synthetic */ xk a;
    final /* synthetic */ di b;
    final /* synthetic */ ZoomView c;
    final /* synthetic */ pc d;

    pe(pc pcVar, xk xkVar, di diVar, ZoomView zoomView) {
        this.d = pcVar;
        this.a = xkVar;
        this.b = diVar;
        this.c = zoomView;
    }

    public void a(int i) {
        Point point = new Point(0, 0);
        dv.c(point, this.a);
        do b = this.b.b(this.c);
        dl a = this.b.a(this.c);
        float l = b.l() + a.l();
        do doVar = new do(b);
        doVar.d((float) dv.a(i, 0, 360));
        this.b.a(this.c, doVar);
        dl dlVar = new dl(a);
        dlVar.d(l - doVar.l());
        this.b.a(this.c, dlVar);
        this.b.getViewTreeObserver().addOnPreDrawListener(new pf(this, point));
    }
}

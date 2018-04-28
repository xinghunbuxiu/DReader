package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.View;

class gf implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f10229a;
    /* renamed from: b */
    final /* synthetic */ Point f10230b;
    /* renamed from: c */
    final /* synthetic */ float f10231c;
    /* renamed from: d */
    final /* synthetic */ int f10232d;
    /* renamed from: e */
    final /* synthetic */ View f10233e;
    /* renamed from: f */
    final /* synthetic */ gd f10234f;

    gf(gd gdVar, boolean z, Point point, float f, int i, View view) {
        this.f10234f = gdVar;
        this.f10229a = z;
        this.f10230b = point;
        this.f10231c = f;
        this.f10232d = i;
        this.f10233e = view;
    }

    public void run() {
        float i = this.f10229a ? this.f10234f.mo2421i() : this.f10234f.getZoomFactor();
        Runnable ggVar = new gg(this, i);
        this.f10234f.m1351a((float) this.f10230b.x, (float) this.f10230b.y, this.f10231c, ((float) this.f10232d) + this.f10234f.getZoomAngle());
        this.f10234f.m1352a((float) (this.f10233e.getWidth() / 2), (float) (this.f10233e.getHeight() / 2), i, 0.0f, ggVar, ggVar);
    }
}

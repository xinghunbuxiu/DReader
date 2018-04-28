package com.duokan.reader.ui.reading;

import android.graphics.PointF;

class abo implements Runnable {
    /* renamed from: a */
    final /* synthetic */ PointF f9401a;
    /* renamed from: b */
    final /* synthetic */ Runnable f9402b;
    /* renamed from: c */
    final /* synthetic */ Runnable f9403c;
    /* renamed from: d */
    final /* synthetic */ abe f9404d;

    abo(abe abe, PointF pointF, Runnable runnable, Runnable runnable2) {
        this.f9404d = abe;
        this.f9401a = pointF;
        this.f9402b = runnable;
        this.f9403c = runnable2;
    }

    public void run() {
        this.f9404d.f9382d.pageUpSmoothly(this.f9401a, this.f9402b, this.f9403c);
        this.f9404d.f9387i = null;
    }
}

package com.duokan.reader.ui.reading;

import android.graphics.PointF;

class abp implements Runnable {
    /* renamed from: a */
    final /* synthetic */ PointF f9405a;
    /* renamed from: b */
    final /* synthetic */ Runnable f9406b;
    /* renamed from: c */
    final /* synthetic */ Runnable f9407c;
    /* renamed from: d */
    final /* synthetic */ abe f9408d;

    abp(abe abe, PointF pointF, Runnable runnable, Runnable runnable2) {
        this.f9408d = abe;
        this.f9405a = pointF;
        this.f9406b = runnable;
        this.f9407c = runnable2;
    }

    public void run() {
        this.f9408d.f9382d.pageDownSmoothly(this.f9405a, this.f9406b, this.f9407c);
        this.f9408d.f9387i = null;
    }
}

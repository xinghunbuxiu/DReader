package com.duokan.reader.ui.account;

import android.graphics.Bitmap;
import android.graphics.Canvas;

class cn implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1270v f5933a;
    /* renamed from: b */
    final /* synthetic */ Canvas f5934b;
    /* renamed from: c */
    final /* synthetic */ long f5935c;
    /* renamed from: d */
    final /* synthetic */ co f5936d;
    /* renamed from: e */
    final /* synthetic */ Bitmap f5937e;
    /* renamed from: f */
    final /* synthetic */ bx f5938f;

    cn(bx bxVar, C1270v c1270v, Canvas canvas, long j, co coVar, Bitmap bitmap) {
        this.f5938f = bxVar;
        this.f5933a = c1270v;
        this.f5934b = canvas;
        this.f5935c = j;
        this.f5936d = coVar;
        this.f5937e = bitmap;
    }

    public void run() {
        this.f5933a.draw(this.f5934b);
        if (!this.f5933a.m9023a() || System.currentTimeMillis() - this.f5935c >= 5000) {
            this.f5938f.f5901m = false;
            this.f5936d.mo1586a(this.f5937e, true);
            return;
        }
        if (!this.f5938f.f5900l.isShowing()) {
            this.f5938f.f5900l.show();
        }
        this.f5938f.f5903o.postDelayed(this, 1000);
    }
}

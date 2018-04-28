package com.duokan.reader.ui.account;

import android.graphics.Bitmap;
import android.graphics.Canvas;

class bb implements Runnable {
    /* renamed from: a */
    final /* synthetic */ aa f5855a;
    /* renamed from: b */
    final /* synthetic */ Canvas f5856b;
    /* renamed from: c */
    final /* synthetic */ long f5857c;
    /* renamed from: d */
    final /* synthetic */ bt f5858d;
    /* renamed from: e */
    final /* synthetic */ Bitmap f5859e;
    /* renamed from: f */
    final /* synthetic */ ay f5860f;

    bb(ay ayVar, aa aaVar, Canvas canvas, long j, bt btVar, Bitmap bitmap) {
        this.f5860f = ayVar;
        this.f5855a = aaVar;
        this.f5856b = canvas;
        this.f5857c = j;
        this.f5858d = btVar;
        this.f5859e = bitmap;
    }

    public void run() {
        if (this.f5860f.f) {
            this.f5855a.draw(this.f5856b);
            if (!this.f5855a.mo1579a() || System.currentTimeMillis() - this.f5857c >= 5000) {
                this.f5860f.f = false;
                this.f5858d.mo1573a(this.f5859e, true);
                return;
            }
            this.f5860f.f5850a.postDelayed(this, 1000);
        }
    }
}

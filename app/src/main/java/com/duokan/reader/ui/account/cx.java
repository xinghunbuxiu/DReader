package com.duokan.reader.ui.account;

import android.graphics.Bitmap;
import android.graphics.Canvas;

class cx implements Runnable {
    final /* synthetic */ ai a;
    final /* synthetic */ Canvas b;
    final /* synthetic */ long c;
    final /* synthetic */ cy d;
    final /* synthetic */ Bitmap e;
    final /* synthetic */ ch f;

    cx(ch chVar, ai aiVar, Canvas canvas, long j, cy cyVar, Bitmap bitmap) {
        this.f = chVar;
        this.a = aiVar;
        this.b = canvas;
        this.c = j;
        this.d = cyVar;
        this.e = bitmap;
    }

    public void run() {
        this.a.draw(this.b);
        if (!this.a.a() || System.currentTimeMillis() - this.c >= 5000) {
            this.f.m = false;
            this.d.a(this.e, true);
            return;
        }
        if (!this.f.l.isShowing()) {
            this.f.l.show();
        }
        this.f.o.postDelayed(this, 1000);
    }
}

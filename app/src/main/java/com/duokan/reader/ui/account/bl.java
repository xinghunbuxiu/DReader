package com.duokan.reader.ui.account;

import android.graphics.Bitmap;
import android.graphics.Canvas;

class bl implements Runnable {
    final /* synthetic */ an a;
    final /* synthetic */ Canvas b;
    final /* synthetic */ long c;
    final /* synthetic */ cd d;
    final /* synthetic */ Bitmap e;
    final /* synthetic */ bi f;

    bl(bi biVar, an anVar, Canvas canvas, long j, cd cdVar, Bitmap bitmap) {
        this.f = biVar;
        this.a = anVar;
        this.b = canvas;
        this.c = j;
        this.d = cdVar;
        this.e = bitmap;
    }

    public void run() {
        if (this.f.d) {
            this.a.draw(this.b);
            if (!this.a.a() || System.currentTimeMillis() - this.c >= 5000) {
                this.f.d = false;
                this.d.a(this.e, true);
                return;
            }
            this.f.f.postDelayed(this, 1000);
        }
    }
}

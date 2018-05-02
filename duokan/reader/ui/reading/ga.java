package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.View;

class ga implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ Point b;
    final /* synthetic */ float c;
    final /* synthetic */ int d;
    final /* synthetic */ View e;
    final /* synthetic */ fy f;

    ga(fy fyVar, boolean z, Point point, float f, int i, View view) {
        this.f = fyVar;
        this.a = z;
        this.b = point;
        this.c = f;
        this.d = i;
        this.e = view;
    }

    public void run() {
        float i = this.a ? this.f.i() : this.f.getZoomFactor();
        Runnable gbVar = new gb(this, i);
        this.f.a((float) this.b.x, (float) this.b.y, this.c, ((float) this.d) + this.f.getZoomAngle());
        this.f.a((float) (this.e.getWidth() / 2), (float) (this.e.getHeight() / 2), i, 0.0f, gbVar, gbVar);
    }
}

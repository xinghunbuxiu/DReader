package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.View;

class ada implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Point f9499a;
    /* renamed from: b */
    final /* synthetic */ View f9500b;
    /* renamed from: c */
    final /* synthetic */ TextSelectionController f9501c;

    ada(TextSelectionController textSelectionController, Point point, View view) {
        this.f9501c = textSelectionController;
        this.f9499a = point;
        this.f9500b = view;
    }

    public void run() {
        this.f9501c.m12567c(this.f9499a.x, this.f9499a.y, this.f9501c.f9152a, this.f9500b);
        this.f9501c.m12558a(false);
    }
}

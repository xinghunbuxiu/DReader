package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.View;

class acv implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Point f9486a;
    /* renamed from: b */
    final /* synthetic */ View f9487b;
    /* renamed from: c */
    final /* synthetic */ TextSelectionController f9488c;

    acv(TextSelectionController textSelectionController, Point point, View view) {
        this.f9488c = textSelectionController;
        this.f9486a = point;
        this.f9487b = view;
    }

    public void run() {
        this.f9488c.m12567c(this.f9486a.x, this.f9486a.y, this.f9488c.f9152a, this.f9487b);
        this.f9488c.m12558a(false);
    }
}

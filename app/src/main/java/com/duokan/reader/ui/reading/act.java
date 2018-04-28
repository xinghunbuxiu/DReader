package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.View;

class act implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Point f9481a;
    /* renamed from: b */
    final /* synthetic */ Point f9482b;
    /* renamed from: c */
    final /* synthetic */ View f9483c;
    /* renamed from: d */
    final /* synthetic */ TextSelectionController f9484d;

    act(TextSelectionController textSelectionController, Point point, Point point2, View view) {
        this.f9484d = textSelectionController;
        this.f9481a = point;
        this.f9482b = point2;
        this.f9483c = view;
    }

    public void run() {
        this.f9484d.f9156e.mo2103b(new acu(this));
    }
}

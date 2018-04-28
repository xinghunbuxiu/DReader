package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.View;

class adb implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Point f9502a;
    /* renamed from: b */
    final /* synthetic */ View f9503b;
    /* renamed from: c */
    final /* synthetic */ TextSelectionController f9504c;

    adb(TextSelectionController textSelectionController, Point point, View view) {
        this.f9504c = textSelectionController;
        this.f9502a = point;
        this.f9503b = view;
    }

    public void run() {
        this.f9504c.f9156e.mo2103b(new adc(this));
    }
}

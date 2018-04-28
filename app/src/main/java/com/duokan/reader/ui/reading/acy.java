package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.View;

class acy implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Point f9493a;
    /* renamed from: b */
    final /* synthetic */ Point f9494b;
    /* renamed from: c */
    final /* synthetic */ View f9495c;
    /* renamed from: d */
    final /* synthetic */ TextSelectionController f9496d;

    acy(TextSelectionController textSelectionController, Point point, Point point2, View view) {
        this.f9496d = textSelectionController;
        this.f9493a = point;
        this.f9494b = point2;
        this.f9495c = view;
    }

    public void run() {
        this.f9496d.f9156e.mo2103b(new acz(this));
    }
}

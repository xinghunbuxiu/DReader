package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.View;

class acw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Point f9489a;
    /* renamed from: b */
    final /* synthetic */ View f9490b;
    /* renamed from: c */
    final /* synthetic */ TextSelectionController f9491c;

    acw(TextSelectionController textSelectionController, Point point, View view) {
        this.f9491c = textSelectionController;
        this.f9489a = point;
        this.f9490b = view;
    }

    public void run() {
        this.f9491c.f9156e.mo2103b(new acx(this));
    }
}

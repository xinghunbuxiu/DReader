package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.View;

class acn implements Runnable {
    final /* synthetic */ Point a;
    final /* synthetic */ View b;
    final /* synthetic */ TextSelectionController c;

    acn(TextSelectionController textSelectionController, Point point, View view) {
        this.c = textSelectionController;
        this.a = point;
        this.b = view;
    }

    public void run() {
        this.c.c(this.a.x, this.a.y, this.c.a, this.b);
        this.c.a(false);
    }
}

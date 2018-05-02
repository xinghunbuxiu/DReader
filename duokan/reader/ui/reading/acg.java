package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.View;

class acg implements Runnable {
    final /* synthetic */ Point a;
    final /* synthetic */ Point b;
    final /* synthetic */ View c;
    final /* synthetic */ TextSelectionController d;

    acg(TextSelectionController textSelectionController, Point point, Point point2, View view) {
        this.d = textSelectionController;
        this.a = point;
        this.b = point2;
        this.c = view;
    }

    public void run() {
        this.d.e.b(new ach(this));
    }
}

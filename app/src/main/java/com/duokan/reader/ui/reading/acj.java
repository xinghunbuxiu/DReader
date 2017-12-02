package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.View;

class acj implements Runnable {
    final /* synthetic */ Point a;
    final /* synthetic */ View b;
    final /* synthetic */ TextSelectionController c;

    acj(TextSelectionController textSelectionController, Point point, View view) {
        this.c = textSelectionController;
        this.a = point;
        this.b = view;
    }

    public void run() {
        this.c.e.b(new ack(this));
    }
}

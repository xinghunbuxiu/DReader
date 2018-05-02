package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.View;

class aco implements Runnable {
    final /* synthetic */ Point a;
    final /* synthetic */ View b;
    final /* synthetic */ TextSelectionController c;

    aco(TextSelectionController textSelectionController, Point point, View view) {
        this.c = textSelectionController;
        this.a = point;
        this.b = view;
    }

    public void run() {
        this.c.e.b(new acp(this));
    }
}

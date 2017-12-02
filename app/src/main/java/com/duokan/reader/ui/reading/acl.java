package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.View;

class acl implements Runnable {
    final /* synthetic */ Point a;
    final /* synthetic */ Point b;
    final /* synthetic */ View c;
    final /* synthetic */ TextSelectionController d;

    acl(TextSelectionController textSelectionController, Point point, Point point2, View view) {
        this.d = textSelectionController;
        this.a = point;
        this.b = point2;
        this.c = view;
    }

    public void run() {
        this.d.e.b(new acm(this));
    }
}

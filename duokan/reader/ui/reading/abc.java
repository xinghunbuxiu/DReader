package com.duokan.reader.ui.reading;

import android.graphics.PointF;

class abc implements Runnable {
    final /* synthetic */ PointF a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ Runnable c;
    final /* synthetic */ aar d;

    abc(aar com_duokan_reader_ui_reading_aar, PointF pointF, Runnable runnable, Runnable runnable2) {
        this.d = com_duokan_reader_ui_reading_aar;
        this.a = pointF;
        this.b = runnable;
        this.c = runnable2;
    }

    public void run() {
        this.d.d.pageDownSmoothly(this.a, this.b, this.c);
        this.d.i = null;
    }
}

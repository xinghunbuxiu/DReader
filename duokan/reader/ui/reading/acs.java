package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.bw;

class acs implements bw {
    final /* synthetic */ MotionEvent a;
    final /* synthetic */ acr b;

    acs(acr com_duokan_reader_ui_reading_acr, MotionEvent motionEvent) {
        this.b = com_duokan_reader_ui_reading_acr;
        this.a = motionEvent;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(View view, PointF pointF) {
        this.b.c(this.b.a.a((int) pointF.x, (int) pointF.y, this.a.getAction(), view));
    }
}

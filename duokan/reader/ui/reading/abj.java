package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.er;
import com.duokan.core.ui.r;

class abj implements r {
    final /* synthetic */ abi a;

    abj(abi com_duokan_reader_ui_reading_abi) {
        this.a = com_duokan_reader_ui_reading_abi;
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (this.a.a.i != null) {
            this.a.a.l();
        } else {
            this.a.a.d.onDragEnd(pointF, pointF2);
        }
        this.a.h = false;
        this.a.d(true);
    }
}

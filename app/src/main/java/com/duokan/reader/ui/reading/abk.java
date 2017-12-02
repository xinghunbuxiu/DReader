package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class abk implements du {
    final /* synthetic */ abi a;

    abk(abi com_duokan_reader_ui_reading_abi) {
        this.a = com_duokan_reader_ui_reading_abi;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        this.a.h = true;
        PointF a = this.a.f;
        a.x += pointF2.x;
        pointF.offset(pointF2.x, pointF2.y);
        if (this.a.a.i == null) {
            this.a.a.d.onDragMove(pointF);
        }
    }
}

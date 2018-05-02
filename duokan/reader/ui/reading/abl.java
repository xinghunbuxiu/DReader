package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class abl implements du {
    final /* synthetic */ abi a;

    abl(abi com_duokan_reader_ui_reading_abi) {
        this.a = com_duokan_reader_ui_reading_abi;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        this.a.g = this.a.g + pointF2.x;
        if (((!this.a.a.a.al() || pointF2.x >= 0.0f) && (this.a.a.a.al() || pointF2.x <= 0.0f)) || this.a.a.a.d(this.a.a.a.Z())) {
            if (((this.a.a.a.al() && pointF2.x > 0.0f) || (!this.a.a.a.al() && pointF2.x < 0.0f)) && !this.a.a.a.ax()) {
                if (this.a.a.h()) {
                    this.a.h = true;
                    this.a.e = pointF;
                    this.a.c(true);
                    this.a.a.i = new abn(this);
                    this.a.a.c(1);
                    return;
                }
                this.a.b(false);
                this.a.d(true);
            }
        } else if (!this.a.a.a.aw()) {
            if (this.a.a.i()) {
                this.a.h = true;
                this.a.e = pointF;
                this.a.c(true);
                this.a.a.i = new abm(this);
                this.a.a.c(-1);
                return;
            }
            this.a.b(false);
            this.a.d(true);
        }
    }
}

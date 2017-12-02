package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class acu implements du {
    final /* synthetic */ acr a;

    acu(acr com_duokan_reader_ui_reading_acr) {
        this.a = com_duokan_reader_ui_reading_acr;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (!this.a.a.g() && this.a.a.d() && !this.a.a.d) {
            if (this.a.a.e.ae().H()) {
                this.a.a.a(SelectionStyle.RAPID_SLIDE, view);
            } else {
                this.a.a.a(SelectionStyle.FAST_SELECTING, view);
            }
        }
    }
}

package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.cu;
import com.duokan.core.ui.er;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.d;

class aei implements cu {
    final /* synthetic */ aeh a;

    aei(aeh com_duokan_reader_ui_reading_aeh) {
        this.a = com_duokan_reader_ui_reading_aeh;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        bb b = this.a.a.a.b((int) pointF.x, (int) pointF.y);
        if (!b.f()) {
            this.a.a.b((d) b.g());
        }
        this.a.d(true);
    }
}

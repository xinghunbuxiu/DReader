package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.du;
import com.duokan.core.ui.er;
import com.duokan.reader.ui.reading.FixedPageClipView.ClipIndicator;

class ir implements du {
    final /* synthetic */ ip a;

    ir(ip ipVar) {
        this.a = ipVar;
    }

    public void onTouchUp(View view, PointF pointF) {
        this.a.d = ClipIndicator.UNKNOW;
        this.a.c.a(this.a.d, pointF, 1);
    }

    public void onTouchDown(View view, PointF pointF) {
        this.a.c.requestDisallowInterceptTouchEvent(true);
        this.a.d = this.a.c.a(pointF);
        this.a.c.a(this.a.d, pointF, 1);
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        this.a.c.a(this.a.d, pointF2, 2);
    }
}

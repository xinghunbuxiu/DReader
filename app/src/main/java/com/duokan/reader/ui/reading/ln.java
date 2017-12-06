package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.onTapListener;
import com.duokan.core.ui.er;

class ln implements onTapListener {
    final /* synthetic */ boolean[] a;
    final /* synthetic */ lj b;

    ln(lj ljVar, boolean[] zArr) {
        this.b = ljVar;
        this.a = zArr;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        this.a[0] = true;
    }
}

package com.duokan.reader.ui.reading.a;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.cu;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

class b implements cu {
    final /* synthetic */ es a;
    final /* synthetic */ a b;

    b(a aVar, es esVar) {
        this.b = aVar;
        this.a = esVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        this.b.d(this.b.a(view, this.a, pointF));
    }
}

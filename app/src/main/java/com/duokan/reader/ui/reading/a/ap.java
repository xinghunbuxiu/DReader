package com.duokan.reader.ui.reading.a;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.cu;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

class ap implements cu {
    final /* synthetic */ es a;
    final /* synthetic */ MotionEvent b;
    final /* synthetic */ ao c;

    ap(ao aoVar, es esVar, MotionEvent motionEvent) {
        this.c = aoVar;
        this.a = esVar;
        this.b = motionEvent;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        this.c.d(this.c.a(view, this.a, this.b));
    }
}

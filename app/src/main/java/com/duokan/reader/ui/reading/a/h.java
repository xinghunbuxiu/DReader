package com.duokan.reader.ui.reading.a;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

import org.apache.http.HttpStatus;

class h implements du {
    final /* synthetic */ MotionEvent a;
    final /* synthetic */ i b;
    final /* synthetic */ g c;

    h(g gVar, MotionEvent motionEvent, i iVar) {
        this.c = gVar;
        this.a = motionEvent;
        this.b = iVar;
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (this.a.getPointerCount() != 2) {
            this.c.b(false);
            return;
        }
        this.b.a((-pointF2.y) / ((float) this.c.a(view, (int) HttpStatus.SC_OK)));
        this.c.c(true);
    }
}

package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.er;
import com.duokan.core.ui.r;

class db implements r {
    final /* synthetic */ cy a;

    db(cy cyVar) {
        this.a = cyVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (this.a.i || Float.compare(this.a.a.d.getFrameScale(), 1.0f) != 0) {
            this.a.a.d.a(pointF2.x, pointF2.y);
        } else if (pointF2.x > 0.0f) {
            this.a.a.g();
            this.a.d(true);
        } else if (pointF2.x < 0.0f) {
            this.a.a.h();
            this.a.d(true);
        }
        this.a.b(false);
    }
}

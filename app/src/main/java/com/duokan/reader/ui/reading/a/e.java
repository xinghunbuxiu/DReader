package com.duokan.reader.ui.reading.a;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class e implements du {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (!this.a.e && (this.a.a.a() || !this.a.a.a())) {
            this.a.e = true;
            this.a.c(true);
            this.a.d(true);
            this.a.a.b();
        } else if (this.a.e) {
            this.a.a.a(pointF2.x, pointF2.y);
        }
    }
}

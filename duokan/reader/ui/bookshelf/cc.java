package com.duokan.reader.ui.bookshelf;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class cc implements du {
    final /* synthetic */ bz a;

    cc(bz bzVar) {
        this.a = bzVar;
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (this.a.g) {
            this.a.h();
            this.a.e.b(view, true);
        }
    }
}

package com.duokan.reader.ui.bookshelf;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.du;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.er;

class cb implements du {
    final /* synthetic */ bz a;

    cb(bz bzVar) {
        this.a = bzVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (this.a.g) {
            UTools.showAnimation(pointF2, view);
            this.a.h.a((int) pointF2.x, (int) pointF2.y);
            this.a.g(true);
        }
    }
}

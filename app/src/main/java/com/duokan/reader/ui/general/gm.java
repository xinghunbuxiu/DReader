package com.duokan.reader.ui.general;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.er;
import com.duokan.core.ui.i;

class gm implements i {
    final /* synthetic */ gk a;

    gm(gk gkVar) {
        this.a = gkVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, int i) {
        float f = 1.0f;
        this.a.b(false);
        this.a.d(true);
        PagesView pagesView = this.a.a;
        int i2 = (int) pointF.x;
        int i3 = (int) pointF.y;
        if (this.a.a.getZoomFactor() == 1.0f) {
            f = 2.0f;
        }
        pagesView.b(i2, i3, f);
    }
}

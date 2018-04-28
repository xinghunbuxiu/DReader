package com.duokan.reader.ui.general;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.C0385i;
import com.duokan.core.ui.er;

class gg implements C0385i {
    /* renamed from: a */
    final /* synthetic */ ge f7273a;

    gg(ge geVar) {
        this.f7273a = geVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo1788a(er erVar, View view, PointF pointF, int i) {
        float f = 1.0f;
        this.f7273a.m1613b(false);
        this.f7273a.m1620d(true);
        PagesView pagesView = this.f7273a.f7268a;
        int i2 = (int) pointF.x;
        int i3 = (int) pointF.y;
        if (this.f7273a.f7268a.getZoomFactor() == 1.0f) {
            f = 2.0f;
        }
        pagesView.m10004b(i2, i3, f);
    }
}

package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.bw;

class lu implements bw {
    /* renamed from: a */
    final /* synthetic */ lt f10591a;

    lu(lt ltVar) {
        this.f10591a = ltVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo521a(View view, PointF pointF) {
        fz a = this.f10591a.m14616a(pointF.x, pointF.y);
        if (a != null) {
            this.f10591a.f10583a.mo2341b(a);
        }
    }
}

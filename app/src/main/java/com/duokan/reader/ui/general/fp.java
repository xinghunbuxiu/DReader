package com.duokan.reader.ui.general;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class fp implements du {
    /* renamed from: a */
    final /* synthetic */ fm f7249a;

    fp(fm fmVar) {
        this.f7249a = fmVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        this.f7249a.f7244f = this.f7249a.f7244f + pointF2.x;
        if (pointF2.x > 0.0f) {
            this.f7249a.f7245g = true;
            this.f7249a.m1617c(true);
        }
    }
}

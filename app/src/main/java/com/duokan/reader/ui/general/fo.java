package com.duokan.reader.ui.general;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class fo implements du {
    /* renamed from: a */
    final /* synthetic */ fm f7248a;

    fo(fm fmVar) {
        this.f7248a = fmVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        this.f7248a.f7243e.x = Math.max(0.0f, this.f7248a.f7243e.x + pointF2.x);
        fs k = this.f7248a.f7240a.m9244k();
        if (k != null) {
            this.f7248a.m10656a(k, Math.round(this.f7248a.f7243e.x), Math.round(this.f7248a.f7243e.x), 0, null);
        }
    }
}

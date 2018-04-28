package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.Scrollable.OverScrollMode;

class gi implements ce {
    /* renamed from: a */
    final /* synthetic */ View f1318a;
    /* renamed from: b */
    final /* synthetic */ gh f1319b;

    gi(gh ghVar, View view) {
        this.f1319b = ghVar;
        this.f1318a = view;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo537a(er erVar, View view, PointF pointF, float f) {
        if (!this.f1319b.f1314g) {
            this.f1319b.f1309a.f870b.m1497a(OverScrollMode.NEVER);
            this.f1319b.f1309a.f870b.m1518b(OverScrollMode.NEVER);
            this.f1319b.f1313f.set(pointF.x + ((float) this.f1319b.f1309a.getScrollX()), pointF.y + ((float) this.f1319b.f1309a.getScrollY()));
            dv.m1900a(this.f1319b.f1313f, this.f1319b.f1309a, this.f1318a);
            this.f1319b.f1314g = true;
            this.f1319b.f1317j = this.f1319b.f1309a.getZoomAngle();
            this.f1319b.m1617c(true);
        }
        this.f1319b.f1316i = this.f1319b.f1309a.getZoomFactor() * f;
        this.f1319b.f1316i = Math.max(this.f1319b.f1309a.getMinZoomFactor() - (this.f1319b.f1309a.getMinZoomFactor() * 0.5f), Math.min(this.f1319b.f1316i, this.f1319b.f1309a.getMaxZoomFactor() + (this.f1319b.f1309a.getMaxZoomFactor() * 0.5f)));
        this.f1319b.f1315h.set(pointF);
    }
}

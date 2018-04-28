package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.ce;
import com.duokan.core.ui.er;

class lw implements ce {
    /* renamed from: a */
    final /* synthetic */ float[] f10595a;
    /* renamed from: b */
    final /* synthetic */ PointF f10596b;
    /* renamed from: c */
    final /* synthetic */ lt f10597c;

    lw(lt ltVar, float[] fArr, PointF pointF) {
        this.f10597c = ltVar;
        this.f10595a = fArr;
        this.f10596b = pointF;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo537a(er erVar, View view, PointF pointF, float f) {
        this.f10595a[0] = f;
        this.f10596b.x = pointF.x;
        this.f10596b.y = pointF.y;
    }
}

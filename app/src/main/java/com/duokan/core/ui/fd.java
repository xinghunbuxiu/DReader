package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.View;

class fd implements bw, cu {
    /* renamed from: a */
    final /* synthetic */ ev f1244a;

    private fd(ev evVar) {
        this.f1244a = evVar;
    }

    public void onTouchDown(View view, PointF pointF) {
        this.f1244a.mo493a(pointF);
    }

    public void onTouchUp(View view, PointF pointF) {
        this.f1244a.mo496b(pointF);
    }

    public void onTouchCancel(View view, PointF pointF) {
        this.f1244a.mo497c(pointF);
    }

    /* renamed from: a */
    public void mo521a(View view, PointF pointF) {
        this.f1244a.mo499e(pointF);
    }

    public void onTap(er erVar, View view, PointF pointF) {
        this.f1244a.mo498d(pointF);
    }
}

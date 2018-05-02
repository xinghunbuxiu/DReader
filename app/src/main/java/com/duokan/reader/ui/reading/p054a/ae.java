package com.duokan.reader.ui.reading.p054a;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import com.duokan.core.ui.C0385i;
import com.duokan.core.ui.er;

/* renamed from: com.duokan.reader.ui.reading.a.ae */
class ae implements C0385i {
    /* renamed from: a */
    final /* synthetic */ af f9188a;
    /* renamed from: b */
    final /* synthetic */ ad f9189b;

    ae(ad adVar, af afVar) {
        this.f9189b = adVar;
        this.f9188a = afVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo1788a(er erVar, View view, PointF pointF, int i) {
        Rect bk = this.f9189b.f9185a.bk();
        this.f9189b.f9186c.set((float) bk.left, (float) bk.top, (float) (view.getWidth() - bk.right), (float) (view.getHeight() - bk.bottom));
        if (this.f9189b.f9186c.contains(pointF.x, pointF.y)) {
            this.f9188a.mo2487a();
            this.f9189b.m1623e();
        }
    }
}

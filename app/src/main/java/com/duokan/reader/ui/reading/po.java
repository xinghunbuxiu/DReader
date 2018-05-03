package com.duokan.reader.ui.reading;

import android.graphics.Point;
import com.duokan.core.app.IScreenRotationChangedListener;
import com.duokan.core.ui.C0380do;
import com.duokan.core.ui.ZoomView;
import com.duokan.core.ui.di;
import com.duokan.core.ui.dl;
import com.duokan.core.ui.AnimUtils;

class po implements IScreenRotationChangedListener {
    /* renamed from: a */
    final /* synthetic */ xx f10802a;
    /* renamed from: b */
    final /* synthetic */ di f10803b;
    /* renamed from: c */
    final /* synthetic */ ZoomView f10804c;
    /* renamed from: d */
    final /* synthetic */ pm f10805d;

    po(pm pmVar, xx xxVar, di diVar, ZoomView zoomView) {
        this.f10805d = pmVar;
        this.f10802a = xxVar;
        this.f10803b = diVar;
        this.f10804c = zoomView;
    }

    /* renamed from: a */
    public void ScreenRotationChanged(int i) {
        Point point = new Point(0, 0);
        AnimUtils.m1945c(point, this.f10802a);
        C0380do b = this.f10803b.m1836b(this.f10804c);
        dl a = this.f10803b.m1826a(this.f10804c);
        float l = b.m1865l() + a.m1865l();
        C0380do c0380do = new C0380do(b);
        c0380do.m1858d((float) AnimUtils.m1892a(i, 0, 360));
        this.f10803b.m1835a(this.f10804c, c0380do);
        dl dlVar = new dl(a);
        dlVar.m1858d(l - c0380do.m1865l());
        this.f10803b.m1830a(this.f10804c, dlVar);
        this.f10803b.getViewTreeObserver().addOnPreDrawListener(new pp(this, point));
    }
}

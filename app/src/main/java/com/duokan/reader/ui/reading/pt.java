package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.widget.ImageView;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.app.IScreenRotationChangedListener;
import com.duokan.core.ui.C0380do;
import com.duokan.core.ui.ZoomView;
import com.duokan.core.ui.di;
import com.duokan.core.ui.dl;
import com.duokan.core.ui.dv;
import com.duokan.reader.DkApp;

class pt implements Runnable {
    /* renamed from: a */
    final /* synthetic */ xx f10824a;
    /* renamed from: b */
    final /* synthetic */ di f10825b;
    /* renamed from: c */
    final /* synthetic */ ZoomView f10826c;
    /* renamed from: d */
    final /* synthetic */ IScreenRotationChangedListener f10827d;
    /* renamed from: e */
    final /* synthetic */ ImageView f10828e;
    /* renamed from: f */
    final /* synthetic */ dl f10829f;
    /* renamed from: g */
    final /* synthetic */ ImageView f10830g;
    /* renamed from: h */
    final /* synthetic */ dl f10831h;
    /* renamed from: i */
    final /* synthetic */ dl f10832i;
    /* renamed from: j */
    final /* synthetic */ pm f10833j;

    pt(pm pmVar, xx xxVar, di diVar, ZoomView zoomView, IScreenRotationChangedListener screenRotationChangedListener, ImageView imageView, dl dlVar, ImageView imageView2, dl dlVar2, dl dlVar3) {
        this.f10833j = pmVar;
        this.f10824a = xxVar;
        this.f10825b = diVar;
        this.f10826c = zoomView;
        this.f10827d = screenRotationChangedListener;
        this.f10828e = imageView;
        this.f10829f = dlVar;
        this.f10830g = imageView2;
        this.f10831h = dlVar2;
        this.f10832i = dlVar3;
    }

    public void run() {
        if (this.f10833j.f10798b != null && !this.f10833j.f10799c) {
            this.f10833j.f10799c = true;
            Point point = new Point(0, 0);
            dv.m1945c(point, this.f10824a);
            C0380do b = this.f10825b.m1836b(this.f10826c);
            dl a = this.f10825b.m1826a(this.f10826c);
            float l = b.m1865l() + a.m1865l();
            C0380do c0380do = new C0380do(b);
            c0380do.m1858d(0.0f);
            this.f10825b.m1835a(this.f10826c, c0380do);
            dl dlVar = new dl(a);
            dlVar.m1858d(l - c0380do.m1865l());
            this.f10825b.m1830a(this.f10826c, dlVar);
            ((BaseActivity) DkApp.get().getTopActivity()).removeOnScreenRotationChangedListener(this.f10827d);
            this.f10825b.getViewTreeObserver().addOnPreDrawListener(new pu(this, point));
        }
    }
}

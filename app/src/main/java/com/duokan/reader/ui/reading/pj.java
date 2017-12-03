package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.widget.ImageView;

import com.duokan.core.app.BaseActivity;
import com.duokan.core.app.s;
import com.duokan.core.ui.ZoomView;
import com.duokan.core.ui.di;
import com.duokan.core.ui.dl;
import com.duokan.core.ui.UTools;
import com.duokan.reader.DkApp;

do;

class pj implements Runnable {
    final /* synthetic */ xk a;
    final /* synthetic */ di b;
    final /* synthetic */ ZoomView c;
    final /* synthetic */ s d;
    final /* synthetic */ ImageView e;
    final /* synthetic */ dl f;
    final /* synthetic */ ImageView g;
    final /* synthetic */ dl h;
    final /* synthetic */ dl i;
    final /* synthetic */ pc j;

    pj(pc pcVar, xk xkVar, di diVar, ZoomView zoomView, s sVar, ImageView imageView, dl dlVar, ImageView imageView2, dl dlVar2, dl dlVar3) {
        this.j = pcVar;
        this.a = xkVar;
        this.b = diVar;
        this.c = zoomView;
        this.d = sVar;
        this.e = imageView;
        this.f = dlVar;
        this.g = imageView2;
        this.h = dlVar2;
        this.i = dlVar3;
    }

    public void run() {
        if (this.j.b != null && !this.j.c) {
            this.j.c = true;
            Point point = new Point(0, 0);
            UTools.showAnimation(point, this.a);
            do b = this.b.b(this.c);
            dl a = this.b.a(this.c);
            float l = b.l() + a.l();
            do doVar = new do (b);
            doVar.d(0.0f);
            this.b.a(this.c, doVar);
            dl dlVar = new dl(a);
            dlVar.d(l - doVar.l());
            this.b.a(this.c, dlVar);
            ((BaseActivity) DkApp.get().getTopActivity()).removeOnScreenRotationChangedListener(this.d);
            this.b.getViewTreeObserver().addOnPreDrawListener(new pk(this, point));
        }
    }
}

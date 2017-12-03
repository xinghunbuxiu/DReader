package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;

import com.duokan.core.app.s;
import com.duokan.core.ui.ZoomView;
import com.duokan.core.ui.di;
import com.duokan.core.ui.dl;
import com.duokan.core.ui.UTools;

import org.apache.http.HttpStatus;

class ph implements OnPreDrawListener {
    final /* synthetic */ xk a;
    final /* synthetic */ dl b;
    final /* synthetic */ Rect c;
    final /* synthetic */ ZoomView d;
    final /* synthetic */ di e;
    final /* synthetic */ ImageView f;
    final /* synthetic */ dl g;
    final /* synthetic */ dl h;
    final /* synthetic */ ImageView i;
    final /* synthetic */ dl j;
    final /* synthetic */ dl k;
    final /* synthetic */ dl l;
    final /* synthetic */ s m;
    final /* synthetic */ pc n;

    ph(pc pcVar, xk xkVar, dl dlVar, Rect rect, ZoomView zoomView, di diVar, ImageView imageView, dl dlVar2, dl dlVar3, ImageView imageView2, dl dlVar4, dl dlVar5, dl dlVar6, s sVar) {
        this.n = pcVar;
        this.a = xkVar;
        this.b = dlVar;
        this.c = rect;
        this.d = zoomView;
        this.e = diVar;
        this.f = imageView;
        this.g = dlVar2;
        this.h = dlVar3;
        this.i = imageView2;
        this.j = dlVar4;
        this.k = dlVar5;
        this.l = dlVar6;
        this.m = sVar;
    }

    public boolean onPreDraw() {
        Point point = (Point) UTools.e.getRect();
        UTools.getTouchPoint(point, this.a, this.n.a);
        this.b.a(this.c.left - point.x, this.c.top - point.y);
        this.b.a(0.0f, 0.0f, ((float) (this.d.getWidth() - this.c.width())) / ((float) this.d.getWidth()), ((float) (this.d.getHeight() - this.c.height())) / ((float) this.d.getHeight()));
        this.e.a(this.f, this.g, this.h, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
        this.e.a(this.i, this.j, this.k, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
        this.e.a(this.d, this.b, this.l, HttpStatus.SC_INTERNAL_SERVER_ERROR, new pi(this), null);
        this.e.getViewTreeObserver().removeOnPreDrawListener(this);
        UTools.e.getRect(point);
        return false;
    }
}

package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.duokan.core.app.IScreenRotationChangedListener;
import com.duokan.core.ui.ZoomView;
import com.duokan.core.ui.di;
import com.duokan.core.ui.dl;
import com.duokan.core.ui.AnimUtils;
import org.apache.http.HttpStatus;

class pr implements OnPreDrawListener {
    /* renamed from: a */
    final /* synthetic */ xx f10809a;
    /* renamed from: b */
    final /* synthetic */ dl f10810b;
    /* renamed from: c */
    final /* synthetic */ Rect f10811c;
    /* renamed from: d */
    final /* synthetic */ ZoomView f10812d;
    /* renamed from: e */
    final /* synthetic */ di f10813e;
    /* renamed from: f */
    final /* synthetic */ ImageView f10814f;
    /* renamed from: g */
    final /* synthetic */ dl f10815g;
    /* renamed from: h */
    final /* synthetic */ dl f10816h;
    /* renamed from: i */
    final /* synthetic */ ImageView f10817i;
    /* renamed from: j */
    final /* synthetic */ dl f10818j;
    /* renamed from: k */
    final /* synthetic */ dl f10819k;
    /* renamed from: l */
    final /* synthetic */ dl f10820l;
    /* renamed from: m */
    final /* synthetic */ IScreenRotationChangedListener f10821m;
    /* renamed from: n */
    final /* synthetic */ pm f10822n;

    pr(pm pmVar, xx xxVar, dl dlVar, Rect rect, ZoomView zoomView, di diVar, ImageView imageView, dl dlVar2, dl dlVar3, ImageView imageView2, dl dlVar4, dl dlVar5, dl dlVar6, IScreenRotationChangedListener screenRotationChangedListener) {
        this.f10822n = pmVar;
        this.f10809a = xxVar;
        this.f10810b = dlVar;
        this.f10811c = rect;
        this.f10812d = zoomView;
        this.f10813e = diVar;
        this.f10814f = imageView;
        this.f10815g = dlVar2;
        this.f10816h = dlVar3;
        this.f10817i = imageView2;
        this.f10818j = dlVar4;
        this.f10819k = dlVar5;
        this.f10820l = dlVar6;
        this.f10821m = screenRotationChangedListener;
    }

    public boolean onPreDraw() {
        Point point = (Point) AnimUtils.f1196e.addAnimation();
        AnimUtils.m1897a(point, this.f10809a, this.f10822n.f10797a);
        this.f10810b.m1853a(this.f10811c.left - point.x, this.f10811c.top - point.y);
        this.f10810b.m1870a(0.0f, 0.0f, ((float) (this.f10812d.getWidth() - this.f10811c.width())) / ((float) this.f10812d.getWidth()), ((float) (this.f10812d.getHeight() - this.f10811c.height())) / ((float) this.f10812d.getHeight()));
        this.f10813e.m1833a(this.f10814f, this.f10815g, this.f10816h, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
        this.f10813e.m1833a(this.f10817i, this.f10818j, this.f10819k, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
        this.f10813e.m1834a(this.f10812d, this.f10810b, this.f10820l, HttpStatus.SC_INTERNAL_SERVER_ERROR, new ps(this), null);
        this.f10813e.getViewTreeObserver().removeOnPreDrawListener(this);
        AnimUtils.f1196e.clearAnimation(point);
        return false;
    }
}

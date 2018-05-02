package com.duokan.reader.ui.general;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;

class kp {
    public final char[] a;
    public final int b;
    public final int c;
    public final int d;
    public final PointF e = new PointF();
    public final RectF f = new RectF();
    public final Rect g = new Rect();
    final /* synthetic */ km h;

    public kp(km kmVar, char[] cArr, int i, int i2, int i3, PointF pointF, RectF rectF, Rect rect) {
        this.h = kmVar;
        this.a = cArr;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e.x = pointF.x;
        this.e.y = pointF.y;
        this.f.top = rectF.top;
        this.f.left = rectF.left;
        this.f.bottom = rectF.bottom;
        this.f.right = rectF.right;
        this.g.top = rect.top;
        this.g.left = rect.left;
        this.g.bottom = rect.bottom;
        this.g.right = rect.right;
    }
}

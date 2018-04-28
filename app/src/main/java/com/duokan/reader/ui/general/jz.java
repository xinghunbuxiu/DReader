package com.duokan.reader.ui.general;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;

class jz {
    /* renamed from: a */
    public final char[] f7488a;
    /* renamed from: b */
    public final int f7489b;
    /* renamed from: c */
    public final int f7490c;
    /* renamed from: d */
    public final int f7491d;
    /* renamed from: e */
    public final PointF f7492e = new PointF();
    /* renamed from: f */
    public final RectF f7493f = new RectF();
    /* renamed from: g */
    public final Rect f7494g = new Rect();
    /* renamed from: h */
    final /* synthetic */ jw f7495h;

    public jz(jw jwVar, char[] cArr, int i, int i2, int i3, PointF pointF, RectF rectF, Rect rect) {
        this.f7495h = jwVar;
        this.f7488a = cArr;
        this.f7489b = i;
        this.f7490c = i2;
        this.f7491d = i3;
        this.f7492e.x = pointF.x;
        this.f7492e.y = pointF.y;
        this.f7493f.top = rectF.top;
        this.f7493f.left = rectF.left;
        this.f7493f.bottom = rectF.bottom;
        this.f7493f.right = rectF.right;
        this.f7494g.top = rect.top;
        this.f7494g.left = rect.left;
        this.f7494g.bottom = rect.bottom;
        this.f7494g.right = rect.right;
    }
}

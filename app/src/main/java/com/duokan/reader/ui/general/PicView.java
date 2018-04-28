package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.util.AttributeSet;
import android.view.View;

public class PicView extends View {
    /* renamed from: a */
    private static final Rect f6878a = new Rect();
    /* renamed from: b */
    private final gl f6879b;
    /* renamed from: c */
    private final Callback f6880c;
    /* renamed from: d */
    private gr f6881d;

    public PicView(Context context) {
        this(context, null);
    }

    public PicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6880c = new gp(this);
        this.f6881d = null;
        this.f6879b = new gl(getContext());
        this.f6879b.setCallback(this.f6880c);
        this.f6879b.m10718a(new gq(this));
        setWillNotDraw(false);
        setWillNotCacheDrawing(false);
        setDrawingCacheEnabled(false);
    }

    public final Drawable getPicForeground() {
        return this.f6879b.m10711a();
    }

    public final void setPicForeground(Drawable drawable) {
        this.f6879b.m10716a(drawable);
    }

    public final void setDefaultPic(int i) {
        this.f6879b.m10713a(i);
    }

    public final String getPicUri() {
        return this.f6879b.m10721b();
    }

    public gl getDrawable() {
        return this.f6879b;
    }

    public final void setPicStretch(PicStretch picStretch) {
        this.f6879b.m10717a(picStretch);
    }

    public final void setColorMatrix(ColorMatrix colorMatrix) {
        this.f6879b.m10715a(colorMatrix);
    }

    public final void setPicListener(gr grVar) {
        this.f6881d = grVar;
    }

    public final void setCornerRadius(float f) {
        this.f6879b.m10712a(f);
    }

    public final float getCornerRadius() {
        return this.f6879b.m10723c();
    }

    /* renamed from: a */
    public final boolean m10152a() {
        return this.f6879b.m10724d();
    }

    protected void onDraw(Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        f6878a.set(paddingLeft, paddingTop, ((getWidth() - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((getHeight() - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        this.f6879b.setBounds(f6878a);
        this.f6879b.m10714a(canvas);
    }
}

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
    private static final Rect a = new Rect();
    private final gw b;
    private final Callback c;
    private hc d;

    public PicView(Context context) {
        this(context, null);
    }

    public PicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new ha(this);
        this.d = null;
        this.b = new gw(getContext());
        this.b.setCallback(this.c);
        this.b.a(new hb(this));
        setWillNotDraw(false);
        setWillNotCacheDrawing(false);
        setDrawingCacheEnabled(false);
    }

    public final Drawable getPicForeground() {
        return this.b.a();
    }

    public final void setPicForeground(Drawable drawable) {
        this.b.a(drawable);
    }

    public final void setDefaultPic(int i) {
        this.b.a(i);
    }

    public final String getPicUri() {
        return this.b.b();
    }

    public gw getDrawable() {
        return this.b;
    }

    public final void setPicStretch(PicStretch picStretch) {
        this.b.a(picStretch);
    }

    public final void setColorMatrix(ColorMatrix colorMatrix) {
        this.b.a(colorMatrix);
    }

    public final void setPicListener(hc hcVar) {
        this.d = hcVar;
    }

    public final void setCornerRadius(float f) {
        this.b.a(f);
    }

    public final float getCornerRadius() {
        return this.b.c();
    }

    public final boolean a() {
        return this.b.d();
    }

    protected void onDraw(Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        a.set(paddingLeft, paddingTop, ((getWidth() - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((getHeight() - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        this.b.setBounds(a);
        this.b.a(canvas);
    }
}

package com.duokan.reader.ui.reading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class nt extends Drawable {
    /* renamed from: a */
    final /* synthetic */ Drawable f10696a;
    /* renamed from: b */
    final /* synthetic */ Drawable f10697b;
    /* renamed from: c */
    final /* synthetic */ ns f10698c;

    nt(ns nsVar, Drawable drawable, Drawable drawable2) {
        this.f10698c = nsVar;
        this.f10696a = drawable;
        this.f10697b = drawable2;
    }

    public int getIntrinsicHeight() {
        return 1;
    }

    public int getMinimumHeight() {
        return 1;
    }

    public void draw(Canvas canvas) {
        this.f10698c.getPaddingLeft();
        this.f10698c.getPaddingRight();
        Rect bounds = getBounds();
        this.f10696a.setBounds(0, bounds.top, bounds.left, bounds.bottom);
        this.f10696a.draw(canvas);
        this.f10697b.setBounds(bounds);
        this.f10697b.draw(canvas);
        this.f10696a.setBounds(bounds.right, bounds.top, this.f10698c.getWidth(), bounds.bottom);
        this.f10696a.draw(canvas);
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}

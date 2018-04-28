package com.duokan.core.ui;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;

class aq extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ HatGridView f964a;
    /* renamed from: b */
    private final View f965b;
    /* renamed from: c */
    private final View f966c;
    /* renamed from: d */
    private final View f967d;

    /* renamed from: a */
    public void m1599a() {
        Point point = new Point(0, this.f964a.f836z.f908g);
        this.f964a.f811a.m1121b(point);
        scrollTo(0, -(point.y - this.f964a.f836z.f904c.getTop()));
        invalidate();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f965b.layout(0, getHeight() - this.f965b.getMeasuredHeight(), getWidth(), getHeight());
        if (this.f966c != null) {
            this.f966c.layout(0, Math.min(0, -this.f964a.f836z.f909h), getWidth(), getHeight() - this.f965b.getMeasuredHeight());
        }
        if (this.f967d != null) {
            this.f967d.layout(0, getHeight() - this.f965b.getMeasuredHeight(), getWidth(), ((getHeight() - this.f965b.getMeasuredHeight()) + this.f964a.f836z.f910i) + Math.max(0, this.f964a.f836z.f909h));
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        if (this.f966c != null) {
            drawChild(canvas, this.f966c, getDrawingTime());
        }
        if (this.f967d != null) {
            canvas.save();
            canvas.clipRect(this.f967d.getLeft(), this.f965b.getTop() + this.f964a.f836z.f914m, this.f967d.getRight(), (this.f965b.getTop() + this.f964a.f836z.f914m) + this.f967d.getHeight());
            drawChild(canvas, this.f967d, getDrawingTime());
            canvas.restore();
        }
        canvas.save();
        canvas.clipRect(this.f965b.getLeft(), this.f965b.getTop(), this.f965b.getRight(), this.f965b.getTop() + this.f964a.f836z.f914m);
        drawChild(canvas, this.f965b, getDrawingTime());
        canvas.restore();
    }
}

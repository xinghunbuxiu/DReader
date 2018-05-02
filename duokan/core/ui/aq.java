package com.duokan.core.ui;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;

class aq extends FrameLayout {
    final /* synthetic */ HatGridView a;
    private final View b;
    private final View c;
    private final View d;

    public void a() {
        Point point = new Point(0, this.a.z.g);
        this.a.a.b(point);
        scrollTo(0, -(point.y - this.a.z.c.getTop()));
        invalidate();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.b.layout(0, getHeight() - this.b.getMeasuredHeight(), getWidth(), getHeight());
        if (this.c != null) {
            this.c.layout(0, Math.min(0, -this.a.z.h), getWidth(), getHeight() - this.b.getMeasuredHeight());
        }
        if (this.d != null) {
            this.d.layout(0, getHeight() - this.b.getMeasuredHeight(), getWidth(), ((getHeight() - this.b.getMeasuredHeight()) + this.a.z.i) + Math.max(0, this.a.z.h));
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        if (this.c != null) {
            drawChild(canvas, this.c, getDrawingTime());
        }
        if (this.d != null) {
            canvas.save();
            canvas.clipRect(this.d.getLeft(), this.b.getTop() + this.a.z.m, this.d.getRight(), (this.b.getTop() + this.a.z.m) + this.d.getHeight());
            drawChild(canvas, this.d, getDrawingTime());
            canvas.restore();
        }
        canvas.save();
        canvas.clipRect(this.b.getLeft(), this.b.getTop(), this.b.getRight(), this.b.getTop() + this.a.z.m);
        drawChild(canvas, this.b, getDrawingTime());
        canvas.restore();
    }
}

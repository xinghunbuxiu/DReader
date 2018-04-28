package com.duokan.core.ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

class bp extends InsetDrawable {
    /* renamed from: a */
    final /* synthetic */ bk f1028a;
    /* renamed from: b */
    private boolean f1029b = false;

    bp(bk bkVar, Drawable drawable, int i) {
        this.f1028a = bkVar;
        super(drawable, i);
    }

    public void draw(Canvas canvas) {
        this.f1029b = true;
        Rect rect = (Rect) dv.f1198g.addAnimation();
        if (this.f1028a.f1021g != null) {
            if (!this.f1028a.f1021g.hasStarted()) {
                this.f1028a.f1021g.start();
            }
            this.f1028a.f1021g.m1699a(rect, this.f1028a.getDrawingTime());
            invalidateSelf();
        } else {
            this.f1028a.m1682a(rect, this.f1028a.f1018d);
        }
        this.f1028a.f1017c.setState(getState());
        this.f1028a.f1017c.setBounds(0, 0, this.f1028a.getWidth(), this.f1028a.getHeight());
        if (this.f1028a.getOrientation() == 0) {
            canvas.save();
            canvas.clipRect(0, 0, rect.left, this.f1028a.getHeight());
            this.f1028a.f1017c.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.clipRect(rect.right, 0, this.f1028a.getWidth(), this.f1028a.getHeight());
            this.f1028a.f1017c.draw(canvas);
            canvas.restore();
        } else {
            canvas.save();
            canvas.clipRect(0, 0, this.f1028a.getWidth(), rect.top);
            this.f1028a.f1017c.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.clipRect(0, rect.bottom, this.f1028a.getWidth(), this.f1028a.getHeight());
            this.f1028a.f1017c.draw(canvas);
            canvas.restore();
        }
        this.f1028a.f1017c.draw(canvas);
        if (!rect.isEmpty()) {
            canvas.save();
            canvas.clipRect(rect);
            this.f1028a.f1017c.setState(bk.SELECTED_STATE_SET);
            this.f1028a.f1017c.setBounds(0, 0, this.f1028a.getWidth(), this.f1028a.getHeight());
            this.f1028a.f1017c.draw(canvas);
            canvas.restore();
        }
        dv.f1198g.clearAnimation(rect);
        this.f1029b = false;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (!this.f1029b || drawable != this.f1028a.f1017c) {
            super.invalidateDrawable(drawable);
        }
    }
}

package com.duokan.core.ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

class bp extends InsetDrawable {
    final /* synthetic */ bk a;
    private boolean b = false;

    bp(bk bkVar, Drawable drawable, int i) {
        this.a = bkVar;
        super(drawable, i);
    }

    public void draw(Canvas canvas) {
        this.b = true;
        Rect rect = (Rect) dv.g.a();
        if (this.a.g != null) {
            if (!this.a.g.hasStarted()) {
                this.a.g.start();
            }
            this.a.g.a(rect, this.a.getDrawingTime());
            invalidateSelf();
        } else {
            this.a.a(rect, this.a.d);
        }
        this.a.c.setState(getState());
        this.a.c.setBounds(0, 0, this.a.getWidth(), this.a.getHeight());
        if (this.a.getOrientation() == 0) {
            canvas.save();
            canvas.clipRect(0, 0, rect.left, this.a.getHeight());
            this.a.c.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.clipRect(rect.right, 0, this.a.getWidth(), this.a.getHeight());
            this.a.c.draw(canvas);
            canvas.restore();
        } else {
            canvas.save();
            canvas.clipRect(0, 0, this.a.getWidth(), rect.top);
            this.a.c.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.clipRect(0, rect.bottom, this.a.getWidth(), this.a.getHeight());
            this.a.c.draw(canvas);
            canvas.restore();
        }
        this.a.c.draw(canvas);
        if (!rect.isEmpty()) {
            canvas.save();
            canvas.clipRect(rect);
            this.a.c.setState(bk.SELECTED_STATE_SET);
            this.a.c.setBounds(0, 0, this.a.getWidth(), this.a.getHeight());
            this.a.c.draw(canvas);
            canvas.restore();
        }
        dv.g.a(rect);
        this.b = false;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (!this.b || drawable != this.a.c) {
            super.invalidateDrawable(drawable);
        }
    }
}

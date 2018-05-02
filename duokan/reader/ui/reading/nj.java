package com.duokan.reader.ui.reading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class nj extends Drawable {
    final /* synthetic */ Drawable a;
    final /* synthetic */ Drawable b;
    final /* synthetic */ ni c;

    nj(ni niVar, Drawable drawable, Drawable drawable2) {
        this.c = niVar;
        this.a = drawable;
        this.b = drawable2;
    }

    public int getIntrinsicHeight() {
        return 1;
    }

    public int getMinimumHeight() {
        return 1;
    }

    public void draw(Canvas canvas) {
        this.c.getPaddingLeft();
        this.c.getPaddingRight();
        Rect bounds = getBounds();
        this.a.setBounds(0, bounds.top, bounds.left, bounds.bottom);
        this.a.draw(canvas);
        this.b.setBounds(bounds);
        this.b.draw(canvas);
        this.a.setBounds(bounds.right, bounds.top, this.c.getWidth(), bounds.bottom);
        this.a.draw(canvas);
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}

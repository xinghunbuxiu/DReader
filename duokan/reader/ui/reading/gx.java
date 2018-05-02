package com.duokan.reader.ui.reading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class gx extends Drawable {
    final /* synthetic */ gs a;

    private gx(gs gsVar) {
        this.a = gsVar;
    }

    public int getIntrinsicWidth() {
        if (this.a.k == null) {
            return 0;
        }
        return this.a.k.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.a.k == null) {
            return 0;
        }
        return this.a.k.getIntrinsicHeight();
    }

    public void draw(Canvas canvas) {
        this.a.a(canvas, true);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}

package com.duokan.reader.ui.reading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class hc extends Drawable {
    /* renamed from: a */
    final /* synthetic */ gx f10312a;

    private hc(gx gxVar) {
        this.f10312a = gxVar;
    }

    public int getIntrinsicWidth() {
        if (this.f10312a.f10292k == null) {
            return 0;
        }
        return this.f10312a.f10292k.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.f10312a.f10292k == null) {
            return 0;
        }
        return this.f10312a.f10292k.getIntrinsicHeight();
    }

    public void draw(Canvas canvas) {
        this.f10312a.mo2515a(canvas, true);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}

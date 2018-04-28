package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class dz extends Drawable {
    /* renamed from: a */
    final /* synthetic */ dr f7130a;

    dz(dr drVar) {
        this.f7130a = drVar;
    }

    public void draw(Canvas canvas) {
        this.f7130a.m10513h();
        canvas.drawColor(Color.argb((int) (this.f7130a.mo2533e() * 255.0f), 255, 255, 255));
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -3;
    }
}

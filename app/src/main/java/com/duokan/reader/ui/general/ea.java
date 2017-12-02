package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class ea extends Drawable {
    final /* synthetic */ ds a;

    ea(ds dsVar) {
        this.a = dsVar;
    }

    public void draw(Canvas canvas) {
        this.a.e();
        float c = this.a.c();
        if (c == 1.0f) {
            canvas.drawColor(Color.argb((int) (c * 255.0f), 255, 255, 255));
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -3;
    }
}

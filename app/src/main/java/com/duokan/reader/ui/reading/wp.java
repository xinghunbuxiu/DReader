package com.duokan.reader.ui.reading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class wp extends Drawable {
    final /* synthetic */ Drawable a;
    final /* synthetic */ Drawable b;
    final /* synthetic */ wo c;

    wp(wo woVar, Drawable drawable, Drawable drawable2) {
        this.c = woVar;
        this.a = drawable;
        this.b = drawable2;
    }

    public void draw(Canvas canvas) {
        if (this.c.a.g != null) {
            canvas.drawBitmap(this.c.a.g, 0.0f, 0.0f, null);
            return;
        }
        this.a.draw(canvas);
        this.b.draw(canvas);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -1;
    }
}

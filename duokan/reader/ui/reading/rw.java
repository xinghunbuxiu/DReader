package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class rw extends Drawable {
    final /* synthetic */ qh a;

    protected rw(qh qhVar) {
        this.a = qhVar;
    }

    public Bitmap a() {
        return this.a.t;
    }

    public void draw(Canvas canvas) {
        if (this.a.t != null) {
            int i = getBounds().left;
            while (i < getBounds().right) {
                canvas.drawBitmap(this.a.t, (float) i, 0.0f, null);
                i += this.a.t.getWidth();
            }
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -1;
    }
}

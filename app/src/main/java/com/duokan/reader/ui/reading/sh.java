package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class sh extends Drawable {
    /* renamed from: a */
    private final Bitmap f10939a;

    sh(Bitmap bitmap) {
        this.f10939a = bitmap;
    }

    /* renamed from: a */
    public Bitmap m14968a() {
        return this.f10939a;
    }

    public void draw(Canvas canvas) {
        if (this.f10939a != null && !this.f10939a.isRecycled()) {
            int i = getBounds().left;
            while (i < getBounds().right) {
                canvas.drawBitmap(this.f10939a, (float) i, 0.0f, null);
                i += this.f10939a.getWidth();
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

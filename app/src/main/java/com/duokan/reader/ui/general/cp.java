package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.duokan.core.ui.UTools;

class cp extends Drawable {
    private final NinePatch a;
    private int b = 255;
    private Rect c = new Rect();

    public cp(Bitmap bitmap, Rect rect) {
        this.a = new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
        this.c.set(rect);
    }

    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAlpha(this.b);
        paint.setFilterBitmap(true);
        Rect rect = (Rect) UTools.g.getRect();
        rect.set(getBounds());
        this.a.draw(canvas, rect, paint);
        UTools.g.getRect(rect);
    }

    public void setAlpha(int i) {
        this.b = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    public boolean getPadding(Rect rect) {
        rect.set(this.c);
        return true;
    }
}

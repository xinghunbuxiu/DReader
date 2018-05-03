package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.duokan.core.ui.AnimUtils;

class cp extends Drawable {
    /* renamed from: a */
    private final NinePatch f7039a;
    /* renamed from: b */
    private int f7040b = 255;
    /* renamed from: c */
    private Rect f7041c = new Rect();

    public cp(Bitmap bitmap, Rect rect) {
        this.f7039a = new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
        this.f7041c.set(rect);
    }

    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAlpha(this.f7040b);
        paint.setFilterBitmap(true);
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        rect.set(getBounds());
        this.f7039a.draw(canvas, rect, paint);
        AnimUtils.f1198g.clearAnimation(rect);
    }

    public void setAlpha(int i) {
        this.f7040b = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    public boolean getPadding(Rect rect) {
        rect.set(this.f7041c);
        return true;
    }
}

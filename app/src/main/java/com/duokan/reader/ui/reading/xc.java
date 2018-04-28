package com.duokan.reader.ui.reading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class xc extends Drawable {
    /* renamed from: a */
    final /* synthetic */ Drawable f11136a;
    /* renamed from: b */
    final /* synthetic */ Drawable f11137b;
    /* renamed from: c */
    final /* synthetic */ xb f11138c;

    xc(xb xbVar, Drawable drawable, Drawable drawable2) {
        this.f11138c = xbVar;
        this.f11136a = drawable;
        this.f11137b = drawable2;
    }

    public void draw(Canvas canvas) {
        if (this.f11138c.f11135a.f9704g != null) {
            canvas.drawBitmap(this.f11138c.f11135a.f9704g, 0.0f, 0.0f, null);
            return;
        }
        this.f11136a.draw(canvas);
        this.f11137b.draw(canvas);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -1;
    }
}

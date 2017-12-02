package com.duokan.reader.ui.reading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

import com.duokan.core.ui.dv;

class ng extends Drawable {
    int a;
    int b;
    final /* synthetic */ mx c;

    private ng(mx mxVar) {
        this.c = mxVar;
        this.a = 0;
        this.b = 0;
    }

    public void draw(Canvas canvas) {
        Paint paint = (Paint) dv.b.a();
        paint.setColor(this.b);
        canvas.drawRect((float) ((-this.a) + this.c.b.getPaddingLeft()), 0.0f, (float) this.c.b.getWidth(), (float) this.c.b.getHeight(), paint);
        dv.b.a(paint);
    }

    public void a(int i, int i2) {
        this.a = i;
        this.b = i2;
        invalidateSelf();
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}

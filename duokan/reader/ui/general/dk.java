package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class dk extends Drawable {
    private final Paint a = new Paint();
    private float b = 1.0f;
    private int c = 0;
    private int d = 0;
    private int e = 0;

    public dk(int i) {
        this.e = i;
    }

    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    public void a(int i) {
        this.b = (float) i;
    }

    public void draw(Canvas canvas) {
        this.a.setStyle(Style.STROKE);
        this.a.setStrokeWidth(this.b);
        this.a.setColor(this.e);
        this.a.setAntiAlias(true);
        Rect bounds = getBounds();
        float f = (float) (bounds.left + this.c);
        float f2 = ((float) bounds.top) + (this.b / 2.0f);
        float f3 = (float) (bounds.right - this.d);
        float f4 = (float) bounds.top;
        canvas.drawLine(f, f2, f3, (this.b / 2.0f) + f4, this.a);
    }

    public int getIntrinsicHeight() {
        return (int) this.b;
    }

    public int getIntrinsicWidth() {
        return -1;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}

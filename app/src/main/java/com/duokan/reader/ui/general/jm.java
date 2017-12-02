package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class jm extends Drawable {
    private final Paint a = new Paint();
    private float b = 1.0f;
    private int c = 0;

    public jm(int i) {
        this.c = i;
    }

    public void a(int i) {
        this.b = (float) i;
    }

    public void draw(Canvas canvas) {
        this.a.setStyle(Style.STROKE);
        this.a.setStrokeWidth(this.b);
        this.a.setColor(this.c);
        Rect bounds = getBounds();
        canvas.drawLine(((float) bounds.left) + (this.b / 2.0f), (float) bounds.top, ((float) bounds.left) + (this.b / 2.0f), (float) bounds.bottom, this.a);
    }

    public int getIntrinsicHeight() {
        return -1;
    }

    public int getIntrinsicWidth() {
        return (int) this.b;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.a.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}

package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class iw extends Drawable {
    /* renamed from: a */
    private final Paint f7413a = new Paint();
    /* renamed from: b */
    private float f7414b = 1.0f;
    /* renamed from: c */
    private int f7415c = 0;

    public iw(int i) {
        this.f7415c = i;
    }

    /* renamed from: a */
    public void m10815a(int i) {
        this.f7414b = (float) i;
    }

    public void draw(Canvas canvas) {
        this.f7413a.setStyle(Style.STROKE);
        this.f7413a.setStrokeWidth(this.f7414b);
        this.f7413a.setColor(this.f7415c);
        Rect bounds = getBounds();
        canvas.drawLine(((float) bounds.left) + (this.f7414b / 2.0f), (float) bounds.top, ((float) bounds.left) + (this.f7414b / 2.0f), (float) bounds.bottom, this.f7413a);
    }

    public int getIntrinsicHeight() {
        return -1;
    }

    public int getIntrinsicWidth() {
        return (int) this.f7414b;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.f7413a.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f7413a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}

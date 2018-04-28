package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class dk extends Drawable {
    /* renamed from: a */
    private final Paint f7098a = new Paint();
    /* renamed from: b */
    private float f7099b = 1.0f;
    /* renamed from: c */
    private int f7100c = 0;
    /* renamed from: d */
    private int f7101d = 0;
    /* renamed from: e */
    private int f7102e = 0;

    public dk(int i) {
        this.f7102e = i;
    }

    /* renamed from: a */
    public void m10477a(int i, int i2) {
        this.f7100c = i;
        this.f7101d = i2;
    }

    /* renamed from: a */
    public void m10476a(int i) {
        this.f7099b = (float) i;
    }

    public void draw(Canvas canvas) {
        this.f7098a.setStyle(Style.STROKE);
        this.f7098a.setStrokeWidth(this.f7099b);
        this.f7098a.setColor(this.f7102e);
        this.f7098a.setAntiAlias(true);
        Rect bounds = getBounds();
        float f = (float) (bounds.left + this.f7100c);
        float f2 = ((float) bounds.top) + (this.f7099b / 2.0f);
        float f3 = (float) (bounds.right - this.f7101d);
        float f4 = (float) bounds.top;
        canvas.drawLine(f, f2, f3, (this.f7099b / 2.0f) + f4, this.f7098a);
    }

    public int getIntrinsicHeight() {
        return (int) this.f7099b;
    }

    public int getIntrinsicWidth() {
        return -1;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.f7098a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f7098a.setColorFilter(colorFilter);
    }
}

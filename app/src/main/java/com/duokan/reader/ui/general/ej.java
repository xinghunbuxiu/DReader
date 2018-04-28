package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class ej extends Drawable {
    /* renamed from: a */
    private Paint f7152a = new Paint();
    /* renamed from: b */
    private int f7153b = 80;

    public ej() {
        this.f7152a.setAntiAlias(true);
    }

    /* renamed from: a */
    public void m10559a(float f) {
        this.f7152a.setStrokeWidth(f);
    }

    /* renamed from: a */
    public void m10560a(int i) {
        this.f7152a.setColor(i);
    }

    /* renamed from: b */
    public void m10562b(int i) {
        this.f7153b = i;
    }

    /* renamed from: a */
    public void m10561a(Canvas canvas, Rect rect, int i) {
        setBounds(rect);
        m10562b(i);
        draw(canvas);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if ((this.f7153b & 80) == 80) {
            canvas.drawLine((float) bounds.left, (float) bounds.bottom, (float) bounds.right, (float) bounds.bottom, this.f7152a);
        } else if ((this.f7153b & 48) == 48) {
            canvas.drawLine((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.top, this.f7152a);
        } else if ((this.f7153b & 3) == 3) {
            canvas.drawLine((float) bounds.left, (float) bounds.top, (float) bounds.left, (float) bounds.bottom, this.f7152a);
        } else if ((this.f7153b & 5) == 5) {
            canvas.drawLine((float) bounds.right, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.f7152a);
        } else {
            canvas.drawLine((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.f7152a);
        }
    }

    public void setAlpha(int i) {
        this.f7152a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}

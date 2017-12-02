package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class hn extends Drawable {
    private float a;
    private float b;
    private int c;
    private Paint d;

    public hn() {
        this(5.0f, 5.0f, -16777216);
    }

    public hn(float f, float f2, int i) {
        this.d = new Paint();
        this.a = f;
        this.b = f2;
        this.d.setColor(i);
        this.d.setAntiAlias(true);
        this.c = 15;
    }

    public void draw(Canvas canvas) {
        RectF rectF = new RectF(getBounds());
        if (this.c == 0) {
            canvas.drawRect(rectF, this.d);
        } else if ((this.c & 15) == 15) {
            canvas.drawRoundRect(rectF, this.a, this.b, this.d);
        } else {
            Canvas canvas2 = canvas;
            canvas2.drawRect(this.a + rectF.left, this.b + rectF.top, rectF.right - this.a, rectF.bottom - this.b, this.d);
            canvas2 = canvas;
            canvas2.drawRect(rectF.left, this.b + rectF.top, this.a + rectF.left, rectF.bottom - this.b, this.d);
            canvas2 = canvas;
            canvas2.drawRect(this.a + rectF.left, rectF.top, rectF.right - this.a, this.b + rectF.top, this.d);
            canvas2 = canvas;
            canvas2.drawRect(this.a + rectF.left, rectF.bottom - this.b, rectF.right - this.a, rectF.bottom, this.d);
            canvas2 = canvas;
            canvas2.drawRect(rectF.right - this.a, this.b + rectF.top, rectF.right, rectF.bottom - this.b, this.d);
            if ((this.c & 1) == 1) {
                canvas.save();
                canvas.clipRect(rectF.left, rectF.top, rectF.left + this.a, rectF.top + this.b);
                canvas.drawRoundRect(rectF, this.a, this.b, this.d);
                canvas.restore();
            } else {
                canvas2 = canvas;
                canvas2.drawRect(rectF.left, rectF.top, this.a + rectF.left, this.b + rectF.top, this.d);
            }
            if ((this.c & 2) == 2) {
                canvas.save();
                canvas.clipRect(rectF.right - this.a, rectF.top, rectF.right, rectF.top + this.b);
                canvas.drawRoundRect(rectF, this.a, this.b, this.d);
                canvas.restore();
            } else {
                canvas2 = canvas;
                canvas2.drawRect(rectF.right - this.a, rectF.top, rectF.right, this.b + rectF.top, this.d);
            }
            if ((this.c & 4) == 4) {
                canvas.save();
                canvas.clipRect(rectF.left, rectF.bottom - this.b, rectF.left + this.a, rectF.bottom);
                canvas.drawRoundRect(rectF, this.a, this.b, this.d);
                canvas.restore();
            } else {
                canvas2 = canvas;
                canvas2.drawRect(rectF.left, rectF.bottom - this.b, this.a + rectF.left, rectF.bottom, this.d);
            }
            if ((this.c & 8) == 8) {
                canvas.save();
                canvas.clipRect(rectF.right - this.a, rectF.bottom - this.b, rectF.right, rectF.bottom);
                canvas.drawRoundRect(rectF, this.a, this.b, this.d);
                canvas.restore();
                return;
            }
            canvas.drawRect(rectF.right - this.a, rectF.bottom - this.b, rectF.right, rectF.bottom, this.d);
        }
    }

    public void setAlpha(int i) {
    }

    public void a(int i) {
        this.d.setColor(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    public Drawable mutate() {
        return new hn(this.a, this.b, this.d.getColor());
    }
}

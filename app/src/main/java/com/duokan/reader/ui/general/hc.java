package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class hc extends Drawable {
    /* renamed from: a */
    private float f7322a;
    /* renamed from: b */
    private float f7323b;
    /* renamed from: c */
    private int f7324c;
    /* renamed from: d */
    private Paint f7325d;

    public hc() {
        this(5.0f, 5.0f, -16777216);
    }

    public hc(float f, float f2, int i) {
        this.f7325d = new Paint();
        this.f7322a = f;
        this.f7323b = f2;
        this.f7325d.setColor(i);
        this.f7325d.setAntiAlias(true);
        this.f7324c = 15;
    }

    public void draw(Canvas canvas) {
        RectF rectF = new RectF(getBounds());
        if (this.f7324c == 0) {
            canvas.drawRect(rectF, this.f7325d);
        } else if ((this.f7324c & 15) == 15) {
            canvas.drawRoundRect(rectF, this.f7322a, this.f7323b, this.f7325d);
        } else {
            Canvas canvas2 = canvas;
            canvas2.drawRect(this.f7322a + rectF.left, this.f7323b + rectF.top, rectF.right - this.f7322a, rectF.bottom - this.f7323b, this.f7325d);
            canvas2 = canvas;
            canvas2.drawRect(rectF.left, this.f7323b + rectF.top, this.f7322a + rectF.left, rectF.bottom - this.f7323b, this.f7325d);
            canvas2 = canvas;
            canvas2.drawRect(this.f7322a + rectF.left, rectF.top, rectF.right - this.f7322a, this.f7323b + rectF.top, this.f7325d);
            canvas2 = canvas;
            canvas2.drawRect(this.f7322a + rectF.left, rectF.bottom - this.f7323b, rectF.right - this.f7322a, rectF.bottom, this.f7325d);
            canvas2 = canvas;
            canvas2.drawRect(rectF.right - this.f7322a, this.f7323b + rectF.top, rectF.right, rectF.bottom - this.f7323b, this.f7325d);
            if ((this.f7324c & 1) == 1) {
                canvas.save();
                canvas.clipRect(rectF.left, rectF.top, rectF.left + this.f7322a, rectF.top + this.f7323b);
                canvas.drawRoundRect(rectF, this.f7322a, this.f7323b, this.f7325d);
                canvas.restore();
            } else {
                canvas2 = canvas;
                canvas2.drawRect(rectF.left, rectF.top, this.f7322a + rectF.left, this.f7323b + rectF.top, this.f7325d);
            }
            if ((this.f7324c & 2) == 2) {
                canvas.save();
                canvas.clipRect(rectF.right - this.f7322a, rectF.top, rectF.right, rectF.top + this.f7323b);
                canvas.drawRoundRect(rectF, this.f7322a, this.f7323b, this.f7325d);
                canvas.restore();
            } else {
                canvas2 = canvas;
                canvas2.drawRect(rectF.right - this.f7322a, rectF.top, rectF.right, this.f7323b + rectF.top, this.f7325d);
            }
            if ((this.f7324c & 4) == 4) {
                canvas.save();
                canvas.clipRect(rectF.left, rectF.bottom - this.f7323b, rectF.left + this.f7322a, rectF.bottom);
                canvas.drawRoundRect(rectF, this.f7322a, this.f7323b, this.f7325d);
                canvas.restore();
            } else {
                canvas2 = canvas;
                canvas2.drawRect(rectF.left, rectF.bottom - this.f7323b, this.f7322a + rectF.left, rectF.bottom, this.f7325d);
            }
            if ((this.f7324c & 8) == 8) {
                canvas.save();
                canvas.clipRect(rectF.right - this.f7322a, rectF.bottom - this.f7323b, rectF.right, rectF.bottom);
                canvas.drawRoundRect(rectF, this.f7322a, this.f7323b, this.f7325d);
                canvas.restore();
                return;
            }
            canvas.drawRect(rectF.right - this.f7322a, rectF.bottom - this.f7323b, rectF.right, rectF.bottom, this.f7325d);
        }
    }

    public void setAlpha(int i) {
    }

    /* renamed from: a */
    public void m10739a(int i) {
        this.f7325d.setColor(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    public Drawable mutate() {
        return new hc(this.f7322a, this.f7323b, this.f7325d.getColor());
    }
}

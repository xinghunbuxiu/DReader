package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class el extends Drawable {
    private Paint a = new Paint();
    private int b = 80;

    public el() {
        this.a.setAntiAlias(true);
    }

    public void a(float f) {
        this.a.setStrokeWidth(f);
    }

    public void a(int i) {
        this.a.setColor(i);
    }

    public void b(int i) {
        this.b = i;
    }

    public void a(Canvas canvas, Rect rect, int i) {
        setBounds(rect);
        b(i);
        draw(canvas);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if ((this.b & 80) == 80) {
            canvas.drawLine((float) bounds.left, (float) bounds.bottom, (float) bounds.right, (float) bounds.bottom, this.a);
        } else if ((this.b & 48) == 48) {
            canvas.drawLine((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.top, this.a);
        } else if ((this.b & 3) == 3) {
            canvas.drawLine((float) bounds.left, (float) bounds.top, (float) bounds.left, (float) bounds.bottom, this.a);
        } else if ((this.b & 5) == 5) {
            canvas.drawLine((float) bounds.right, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.a);
        } else {
            canvas.drawLine((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.a);
        }
    }

    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}

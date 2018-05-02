package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public class hl extends Drawable {
    private Paint a = new Paint();

    public void a(int i) {
        this.a.setColor(i);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(getBounds(), this.a);
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

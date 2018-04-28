package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public class ha extends Drawable {
    /* renamed from: a */
    private Paint f7317a = new Paint();

    /* renamed from: a */
    public void m10738a(int i) {
        this.f7317a.setColor(i);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(getBounds(), this.f7317a);
    }

    public void setAlpha(int i) {
        this.f7317a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}

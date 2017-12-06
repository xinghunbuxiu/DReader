package com.duokan.reader.ui.reading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.duokan.core.ui.UTools;

class oa extends Drawable {
    final /* synthetic */ nk a;
    private Paint b = new Paint();
    private final int c;

    public oa(nk nkVar, int i) {
        this.a = nkVar;
        this.c = UTools.getMinimumHeight(nkVar.getContext(), 12.0f);
        this.b.setColor(i);
        this.b.setAntiAlias(true);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.drawCircle((float) bounds.centerX(), (float) bounds.centerY(), (float) bounds.centerX(), this.b);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    public int getIntrinsicWidth() {
        return this.c;
    }

    public int getIntrinsicHeight() {
        return this.c;
    }
}

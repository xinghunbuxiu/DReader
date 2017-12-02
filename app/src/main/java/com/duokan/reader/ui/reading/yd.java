package com.duokan.reader.ui.reading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import com.duokan.core.ui.dv;

class yd extends Drawable {
    final /* synthetic */ yb a;

    yd(yb ybVar) {
        this.a = ybVar;
    }

    public void draw(Canvas canvas) {
        RectF rectF = (RectF) dv.h.a();
        Paint paint = (Paint) dv.b.a();
        rectF.set(getBounds());
        rectF.right -= 1.0f;
        rectF.bottom -= 1.0f;
        rectF.inset(0.5f, 0.5f);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Style.STROKE);
        paint.setColor(this.a.g);
        canvas.drawRoundRect(rectF, (float) dv.b(this.a.getContext(), 5.0f), (float) dv.b(this.a.getContext(), 5.0f), paint);
        dv.h.a(rectF);
        dv.b.a(paint);
    }

    public int getOpacity() {
        return 0;
    }

    public boolean getPadding(Rect rect) {
        rect.set(2, 2, 2, 2);
        return true;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}

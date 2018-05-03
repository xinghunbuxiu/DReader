package com.duokan.reader.ui.reading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.duokan.core.ui.AnimUtils;

class yq extends Drawable {
    /* renamed from: a */
    final /* synthetic */ yo f11214a;

    yq(yo yoVar) {
        this.f11214a = yoVar;
    }

    public void draw(Canvas canvas) {
        RectF rectF = (RectF) AnimUtils.f1199h.addAnimation();
        Paint paint = (Paint) AnimUtils.f1193b.addAnimation();
        rectF.set(getBounds());
        rectF.right -= 1.0f;
        rectF.bottom -= 1.0f;
        rectF.inset(0.5f, 0.5f);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Style.STROKE);
        paint.setColor(this.f11214a.f11207g);
        canvas.drawRoundRect(rectF, (float) AnimUtils.m1932b(this.f11214a.getContext(), 5.0f), (float) AnimUtils.m1932b(this.f11214a.getContext(), 5.0f), paint);
        AnimUtils.f1199h.clearAnimation(rectF);
        AnimUtils.f1193b.clearAnimation(paint);
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

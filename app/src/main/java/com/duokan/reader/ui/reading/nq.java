package com.duokan.reader.ui.reading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.duokan.core.ui.AnimUtils;

class nq extends Drawable {
    /* renamed from: a */
    int f10693a;
    /* renamed from: b */
    int f10694b;
    /* renamed from: c */
    final /* synthetic */ nh f10695c;

    private nq(nh nhVar) {
        this.f10695c = nhVar;
        this.f10693a = 0;
        this.f10694b = 0;
    }

    public void draw(Canvas canvas) {
        Paint paint = (Paint) AnimUtils.f1193b.addAnimation();
        paint.setColor(this.f10694b);
        canvas.drawRect((float) ((-this.f10693a) + this.f10695c.f10668b.getPaddingLeft()), 0.0f, (float) this.f10695c.f10668b.getWidth(), (float) this.f10695c.f10668b.getHeight(), paint);
        AnimUtils.f1193b.clearAnimation(paint);
    }

    /* renamed from: a */
    public void m14762a(int i, int i2) {
        this.f10693a = i;
        this.f10694b = i2;
        invalidateSelf();
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}

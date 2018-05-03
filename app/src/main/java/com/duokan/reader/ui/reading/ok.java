package com.duokan.reader.ui.reading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.duokan.core.ui.AnimUtils;

class ok extends Drawable {
    /* renamed from: a */
    final /* synthetic */ nu f10741a;
    /* renamed from: b */
    private Paint f10742b = new Paint();
    /* renamed from: c */
    private final int f10743c;

    public ok(nu nuVar, int i) {
        this.f10741a = nuVar;
        this.f10743c = AnimUtils.m1932b(nuVar.getContext(), 12.0f);
        this.f10742b.setColor(i);
        this.f10742b.setAntiAlias(true);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.drawCircle((float) bounds.centerX(), (float) bounds.centerY(), (float) bounds.centerX(), this.f10742b);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    public int getIntrinsicWidth() {
        return this.f10743c;
    }

    public int getIntrinsicHeight() {
        return this.f10743c;
    }
}

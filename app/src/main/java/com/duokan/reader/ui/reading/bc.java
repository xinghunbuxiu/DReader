package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0243e;

public class bc extends Drawable {
    /* renamed from: a */
    private final Context f9818a;
    /* renamed from: b */
    private final Drawable f9819b;
    /* renamed from: c */
    private final Drawable f9820c;
    /* renamed from: d */
    private int f9821d = 0;
    /* renamed from: e */
    private int f9822e;
    /* renamed from: f */
    private int f9823f;

    public bc(Context context) {
        this.f9818a = context;
        this.f9819b = this.f9818a.getResources().getDrawable(C0243e.general__shared__battery);
        this.f9820c = this.f9818a.getResources().getDrawable(C0243e.general__shared__power);
        this.f9822e = this.f9819b.getIntrinsicHeight();
        this.f9823f = this.f9819b.getIntrinsicWidth();
    }

    /* renamed from: a */
    public void m13766a(int i) {
        if (this.f9821d != i) {
            this.f9821d = Math.max(0, Math.min(i, 100));
            invalidateSelf();
        }
    }

    /* renamed from: b */
    public void m13767b(int i) {
        this.f9819b.setColorFilter(i, Mode.SRC_IN);
        this.f9820c.setColorFilter(i, Mode.SRC_IN);
        invalidateSelf();
    }

    /* renamed from: c */
    public void m13768c(int i) {
        this.f9822e = i;
        this.f9823f = (this.f9819b.getIntrinsicWidth() * this.f9822e) / this.f9819b.getIntrinsicHeight();
    }

    public int getIntrinsicHeight() {
        return this.f9822e;
    }

    public int getIntrinsicWidth() {
        return this.f9823f;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Rect rect = (Rect) dv.f1198g.addAnimation();
        rect.left = bounds.left;
        rect.top = (((bounds.height() - this.f9822e) + 1) / 2) + bounds.top;
        rect.right = rect.left + this.f9823f;
        rect.bottom = rect.top + this.f9822e;
        this.f9819b.setBounds(rect);
        this.f9819b.draw(canvas);
        bounds = (Rect) dv.f1198g.addAnimation();
        this.f9820c.getPadding(bounds);
        int intrinsicWidth = (this.f9819b.getIntrinsicWidth() - bounds.left) - bounds.right;
        rect.left = (int) ((((float) (intrinsicWidth - Math.min(Math.max((this.f9820c.getIntrinsicWidth() - bounds.left) - bounds.right, Math.round(((float) (this.f9821d * intrinsicWidth)) / 100.0f)), intrinsicWidth))) * (((float) this.f9822e) / ((float) this.f9819b.getIntrinsicHeight()))) + ((float) rect.left));
        this.f9820c.setBounds(rect);
        this.f9820c.draw(canvas);
        dv.f1198g.clearAnimation(bounds);
        dv.f1198g.clearAnimation(rect);
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f9819b.setColorFilter(colorFilter);
        this.f9820c.setColorFilter(colorFilter);
    }
}

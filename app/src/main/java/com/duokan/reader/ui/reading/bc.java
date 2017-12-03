package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.duokan.core.ui.UTools;

public class bc extends Drawable {
    private final Context a;
    private final Drawable b;
    private final Drawable c;
    private int d = 0;
    private int e;
    private int f;

    public bc(Context context) {
        this.a = context;
        this.b = this.a.getResources().getDrawable(e.general__shared__battery);
        this.c = this.a.getResources().getDrawable(e.general__shared__power);
        this.e = this.b.getIntrinsicHeight();
        this.f = this.b.getIntrinsicWidth();
    }

    public void a(int i) {
        if (this.d != i) {
            this.d = Math.max(0, Math.min(i, 100));
            invalidateSelf();
        }
    }

    public void b(int i) {
        this.b.setColorFilter(i, Mode.SRC_IN);
        this.c.setColorFilter(i, Mode.SRC_IN);
        invalidateSelf();
    }

    public void c(int i) {
        this.e = i;
        this.f = (this.b.getIntrinsicWidth() * this.e) / this.b.getIntrinsicHeight();
    }

    public int getIntrinsicHeight() {
        return this.e;
    }

    public int getIntrinsicWidth() {
        return this.f;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Rect rect = (Rect) UTools.g.getRect();
        rect.left = bounds.left;
        rect.top = (((bounds.height() - this.e) + 1) / 2) + bounds.top;
        rect.right = rect.left + this.f;
        rect.bottom = rect.top + this.e;
        this.b.setBounds(rect);
        this.b.draw(canvas);
        bounds = (Rect) UTools.g.getRect();
        this.c.getPadding(bounds);
        int intrinsicWidth = (this.b.getIntrinsicWidth() - bounds.left) - bounds.right;
        rect.left = (int) ((((float) (intrinsicWidth - Math.min(Math.max((this.c.getIntrinsicWidth() - bounds.left) - bounds.right, Math.round(((float) (this.d * intrinsicWidth)) / 100.0f)), intrinsicWidth))) * (((float) this.e) / ((float) this.b.getIntrinsicHeight()))) + ((float) rect.left));
        this.c.setBounds(rect);
        this.c.draw(canvas);
        UTools.g.getRect(bounds);
        UTools.g.getRect(rect);
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
        this.c.setColorFilter(colorFilter);
    }
}

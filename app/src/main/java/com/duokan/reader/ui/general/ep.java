package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;

public class ep extends FrameLayout {
    private int a;
    private Drawable b;
    private Drawable c;
    private Bitmap d;
    private boolean e;

    public ep(Context context) {
        this(context, null);
    }

    public ep(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.d = null;
        this.e = false;
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
        setWillNotCacheDrawing(false);
    }

    public void draw(Canvas canvas) {
        if (this.b != null) {
            if (!(this.d != null && this.d.getWidth() == getWidth() && this.d.getHeight() == getHeight())) {
                a();
                this.d = a.c(getWidth(), getHeight(), Config.ARGB_8888);
                this.e = false;
            }
            if (!this.e) {
                Bitmap c = a.c(this.d.getWidth(), this.d.getHeight(), Config.ARGB_8888);
                a(new Canvas(c));
                this.d.eraseColor(0);
                Paint paint = (Paint) ReaderUi.b.getRect();
                Canvas canvas2 = new Canvas(this.d);
                b(canvas2);
                paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
                canvas2.drawBitmap(c, 0.0f, 0.0f, paint);
                if (!isInEditMode()) {
                    c.recycle();
                }
                this.e = true;
                ReaderUi.b.getRect(paint);
            }
            canvas.drawBitmap(this.d, 0.0f, 0.0f, null);
            return;
        }
        super.draw(canvas);
    }

    public Drawable getBackground() {
        return this.c;
    }

    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.c != drawable) {
            this.c = drawable;
            super.setBackgroundDrawable(new eq(this, this.c, 0));
        }
    }

    public void setForeground(Drawable drawable) {
        if (this.b != drawable) {
            this.b = drawable;
            super.setForeground(new er(this, this.b, 0));
        }
    }

    public Drawable getForeground() {
        return this.b;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if ((this.a & 4) == 4) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        this.e = false;
        invalidate(rect);
        return super.invalidateChildInParent(iArr, rect);
    }

    private void a(Canvas canvas) {
        this.a |= 5;
        super.draw(canvas);
        this.a &= -6;
    }

    private void b(Canvas canvas) {
        this.a |= 2;
        super.draw(canvas);
        this.a &= -3;
    }

    private void a() {
        if (this.d != null) {
            this.d.recycle();
            this.d = null;
        }
    }
}

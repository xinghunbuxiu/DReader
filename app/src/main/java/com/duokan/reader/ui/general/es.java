package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

public class es extends InsetDrawable {
    private Drawable a;
    private Bitmap b;
    private boolean c;

    public es(Drawable drawable) {
        this(drawable, 0);
    }

    public es(Drawable drawable, int i) {
        this(drawable, i, i, i, i);
    }

    public es(Drawable drawable, int i, int i2, int i3, int i4) {
        super(drawable, i, i2, i3, i4);
        this.a = null;
        this.b = null;
        this.c = false;
    }

    public void a(Drawable drawable) {
        if (this.a != drawable) {
            this.a = drawable;
            if (this.a == null) {
                a();
            }
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() >= 1 && bounds.height() >= 1) {
            if (this.a != null) {
                if (!(this.b != null && this.b.getWidth() == bounds.width() && this.b.getHeight() == bounds.height())) {
                    a();
                    this.b = a.c(bounds.width(), bounds.height(), Config.ARGB_8888);
                    this.c = false;
                }
                if (!this.c) {
                    this.b.eraseColor(0);
                    Bitmap c = a.c(bounds.width(), bounds.height(), Config.ARGB_8888);
                    c.eraseColor(0);
                    Canvas canvas2 = new Canvas(c);
                    this.a.setBounds(0, 0, bounds.width(), bounds.height());
                    this.a.draw(canvas2);
                    Paint paint = (Paint) ReaderUi.b.getRect();
                    Canvas canvas3 = new Canvas(this.b);
                    canvas3.translate((float) (-bounds.left), (float) (-bounds.top));
                    super.draw(canvas3);
                    paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
                    canvas3.drawBitmap(c, (float) bounds.left, (float) bounds.top, paint);
                    c.recycle();
                    this.c = true;
                    ReaderUi.b.getRect(paint);
                }
                canvas.drawBitmap(this.b, (float) bounds.left, (float) bounds.top, null);
                return;
            }
            super.draw(canvas);
        }
    }

    public void invalidateSelf() {
        this.c = false;
        super.invalidateSelf();
    }

    public void invalidateDrawable(Drawable drawable) {
        this.c = false;
        super.invalidateDrawable(drawable);
    }

    private void a() {
        if (this.b != null) {
            this.b.recycle();
            this.b = null;
        }
    }
}

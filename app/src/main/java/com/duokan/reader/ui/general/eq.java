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
import com.duokan.reader.common.bitmap.C0544a;

public class eq extends InsetDrawable {
    /* renamed from: a */
    private Drawable f7162a;
    /* renamed from: b */
    private Bitmap f7163b;
    /* renamed from: c */
    private boolean f7164c;

    public eq(Drawable drawable) {
        this(drawable, 0);
    }

    public eq(Drawable drawable, int i) {
        this(drawable, i, i, i, i);
    }

    public eq(Drawable drawable, int i, int i2, int i3, int i4) {
        super(drawable, i, i2, i3, i4);
        this.f7162a = null;
        this.f7163b = null;
        this.f7164c = false;
    }

    /* renamed from: a */
    public void m10568a(Drawable drawable) {
        if (this.f7162a != drawable) {
            this.f7162a = drawable;
            if (this.f7162a == null) {
                m10567a();
            }
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() >= 1 && bounds.height() >= 1) {
            if (this.f7162a != null) {
                if (!(this.f7163b != null && this.f7163b.getWidth() == bounds.width() && this.f7163b.getHeight() == bounds.height())) {
                    m10567a();
                    this.f7163b = C0544a.m2447c(bounds.width(), bounds.height(), Config.ARGB_8888);
                    this.f7164c = false;
                }
                if (!this.f7164c) {
                    this.f7163b.eraseColor(0);
                    Bitmap c = C0544a.m2447c(bounds.width(), bounds.height(), Config.ARGB_8888);
                    c.eraseColor(0);
                    Canvas canvas2 = new Canvas(c);
                    this.f7162a.setBounds(0, 0, bounds.width(), bounds.height());
                    this.f7162a.draw(canvas2);
                    Paint paint = (Paint) ReaderUi.b.m878a();
                    Canvas canvas3 = new Canvas(this.f7163b);
                    canvas3.translate((float) (-bounds.left), (float) (-bounds.top));
                    super.draw(canvas3);
                    paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
                    canvas3.drawBitmap(c, (float) bounds.left, (float) bounds.top, paint);
                    c.recycle();
                    this.f7164c = true;
                    ReaderUi.b.m879a(paint);
                }
                canvas.drawBitmap(this.f7163b, (float) bounds.left, (float) bounds.top, null);
                return;
            }
            super.draw(canvas);
        }
    }

    public void invalidateSelf() {
        this.f7164c = false;
        super.invalidateSelf();
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f7164c = false;
        super.invalidateDrawable(drawable);
    }

    /* renamed from: a */
    private void m10567a() {
        if (this.f7163b != null) {
            this.f7163b.recycle();
            this.f7163b = null;
        }
    }
}

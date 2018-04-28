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
import com.duokan.reader.common.bitmap.C0544a;

public class en extends FrameLayout {
    /* renamed from: a */
    private int f7155a;
    /* renamed from: b */
    private Drawable f7156b;
    /* renamed from: c */
    private Drawable f7157c;
    /* renamed from: d */
    private Bitmap f7158d;
    /* renamed from: e */
    private boolean f7159e;

    public en(Context context) {
        this(context, null);
    }

    public en(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7155a = 0;
        this.f7158d = null;
        this.f7159e = false;
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
        setWillNotCacheDrawing(false);
    }

    public void draw(Canvas canvas) {
        if (this.f7156b != null) {
            if (!(this.f7158d != null && this.f7158d.getWidth() == getWidth() && this.f7158d.getHeight() == getHeight())) {
                m10564a();
                this.f7158d = C0544a.m2447c(getWidth(), getHeight(), Config.ARGB_8888);
                this.f7159e = false;
            }
            if (!this.f7159e) {
                Bitmap c = C0544a.m2447c(this.f7158d.getWidth(), this.f7158d.getHeight(), Config.ARGB_8888);
                m10565a(new Canvas(c));
                this.f7158d.eraseColor(0);
                Paint paint = (Paint) ReaderUi.b.m878a();
                Canvas canvas2 = new Canvas(this.f7158d);
                m10566b(canvas2);
                paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
                canvas2.drawBitmap(c, 0.0f, 0.0f, paint);
                if (!isInEditMode()) {
                    c.recycle();
                }
                this.f7159e = true;
                ReaderUi.b.m879a(paint);
            }
            canvas.drawBitmap(this.f7158d, 0.0f, 0.0f, null);
            return;
        }
        super.draw(canvas);
    }

    public Drawable getBackground() {
        return this.f7157c;
    }

    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f7157c != drawable) {
            this.f7157c = drawable;
            super.setBackgroundDrawable(new eo(this, this.f7157c, 0));
        }
    }

    public void setForeground(Drawable drawable) {
        if (this.f7156b != drawable) {
            this.f7156b = drawable;
            super.setForeground(new ep(this, this.f7156b, 0));
        }
    }

    public Drawable getForeground() {
        return this.f7156b;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if ((this.f7155a & 4) == 4) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        this.f7159e = false;
        invalidate(rect);
        return super.invalidateChildInParent(iArr, rect);
    }

    /* renamed from: a */
    private void m10565a(Canvas canvas) {
        this.f7155a |= 5;
        super.draw(canvas);
        this.f7155a &= -6;
    }

    /* renamed from: b */
    private void m10566b(Canvas canvas) {
        this.f7155a |= 2;
        super.draw(canvas);
        this.f7155a &= -3;
    }

    /* renamed from: a */
    private void m10564a() {
        if (this.f7158d != null) {
            this.f7158d.recycle();
            this.f7158d = null;
        }
    }
}

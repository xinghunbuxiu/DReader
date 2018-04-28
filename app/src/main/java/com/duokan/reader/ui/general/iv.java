package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView.ScaleType;
import com.duokan.core.ui.C0377d;

public class iv extends C0377d {
    /* renamed from: b */
    private Drawable f7410b;
    /* renamed from: c */
    private Drawable f7411c;
    /* renamed from: d */
    private Rect f7412d;

    public iv(Context context) {
        this(context, null);
    }

    public iv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7410b = null;
        this.f7411c = null;
        this.f7412d = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843037, 16843119, 16843120});
        this.f7410b = obtainStyledAttributes.hasValue(1) ? obtainStyledAttributes.getDrawable(1) : this.f7410b;
        this.f7411c = obtainStyledAttributes.hasValue(2) ? obtainStyledAttributes.getDrawable(2) : this.f7411c;
        obtainStyledAttributes.recycle();
    }

    public Drawable getTopDrawable() {
        return this.f7410b;
    }

    public void setTopDrawable(Drawable drawable) {
        this.f7410b = drawable;
        requestLayout();
    }

    public Drawable getBottomDrawable() {
        return this.f7411c;
    }

    public void setBottomDrawable(Drawable drawable) {
        this.f7411c = drawable;
        requestLayout();
    }

    protected void onDraw(Canvas canvas) {
        if (this.f7410b != null) {
            this.f7412d.set(0, 0, getWidth(), this.f7410b.getIntrinsicHeight());
            if (this.a == ScaleType.CENTER) {
                this.f7412d.inset(((getWidth() - this.f7410b.getIntrinsicWidth()) + 1) / 2, 0);
            }
            canvas.save();
            canvas.clipRect(this.f7412d);
            this.f7410b.setBounds(this.f7412d);
            this.f7410b.draw(canvas);
            canvas.restore();
        }
        if (this.f7411c != null) {
            this.f7412d.set(0, getHeight() - this.f7411c.getIntrinsicHeight(), getWidth(), getHeight());
            if (this.a == ScaleType.CENTER) {
                this.f7412d.inset(((getWidth() - this.f7410b.getIntrinsicWidth()) + 1) / 2, 0);
            }
            canvas.save();
            canvas.clipRect(this.f7412d);
            this.f7411c.setBounds(this.f7412d);
            this.f7411c.draw(canvas);
            canvas.restore();
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        if (mode != 0) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec((size - getTopDrawableHeight()) - getBottomDrawableHeight(), mode));
        } else {
            super.onMeasure(i, i2);
        }
        setMeasuredDimension(getMeasuredWidth(), (getMeasuredHeight() + getTopDrawableHeight()) + getBottomDrawableHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2 + getTopDrawableHeight(), i3, i4 - getBottomDrawableHeight());
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).offsetTopAndBottom(getTopDrawableHeight());
        }
    }

    private int getTopDrawableHeight() {
        return this.f7410b != null ? this.f7410b.getIntrinsicHeight() : 0;
    }

    private int getBottomDrawableHeight() {
        return this.f7411c != null ? this.f7411c.getIntrinsicHeight() : 0;
    }
}

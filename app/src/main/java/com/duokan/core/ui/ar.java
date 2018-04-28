package com.duokan.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView.ScaleType;

public class ar extends C0377d {
    /* renamed from: b */
    private Drawable f969b;
    /* renamed from: c */
    private Drawable f970c;
    /* renamed from: d */
    private Rect f971d;

    public ar(Context context) {
        this(context, null);
    }

    public ar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f969b = null;
        this.f970c = null;
        this.f971d = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843037, 16843119, 16843120});
        this.f969b = obtainStyledAttributes.hasValue(1) ? obtainStyledAttributes.getDrawable(1) : this.f969b;
        this.f970c = obtainStyledAttributes.hasValue(2) ? obtainStyledAttributes.getDrawable(2) : this.f970c;
        obtainStyledAttributes.recycle();
    }

    public Drawable getLeftDrawable() {
        return this.f969b;
    }

    public void setLeftDrawable(Drawable drawable) {
        this.f969b = drawable;
        requestLayout();
    }

    public Drawable getRightDrawable() {
        return this.f970c;
    }

    public void setRightDrawable(Drawable drawable) {
        this.f970c = drawable;
        requestLayout();
    }

    protected void onDraw(Canvas canvas) {
        if (this.f969b != null) {
            this.f971d.set(0, 0, this.f969b.getIntrinsicWidth(), getHeight());
            if (this.a == ScaleType.CENTER) {
                this.f971d.inset(0, ((getHeight() - this.f969b.getIntrinsicHeight()) + 1) / 2);
            }
            canvas.save();
            canvas.clipRect(this.f971d);
            this.f969b.setBounds(this.f971d);
            this.f969b.draw(canvas);
            canvas.restore();
        }
        if (this.f970c != null) {
            this.f971d.set(getWidth() - this.f970c.getIntrinsicWidth(), 0, getWidth(), getHeight());
            if (this.a == ScaleType.CENTER) {
                this.f971d.inset(0, ((getHeight() - this.f970c.getIntrinsicHeight()) + 1) / 2);
            }
            canvas.save();
            canvas.clipRect(this.f971d);
            this.f970c.setBounds(this.f971d);
            this.f970c.draw(canvas);
            canvas.restore();
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode != 0) {
            super.onMeasure(MeasureSpec.makeMeasureSpec((size - getLeftDrawableWidth()) - getRightDrawableWidth(), mode), i2);
        } else {
            super.onMeasure(i, i2);
        }
        setMeasuredDimension((getMeasuredWidth() + getLeftDrawableWidth()) + getRightDrawableWidth(), getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i + getLeftDrawableWidth(), i2, i3 - getRightDrawableWidth(), i4);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).offsetLeftAndRight(getLeftDrawableWidth());
        }
    }

    private int getLeftDrawableWidth() {
        return this.f969b != null ? this.f969b.getIntrinsicWidth() : 0;
    }

    private int getRightDrawableWidth() {
        return this.f970c != null ? this.f970c.getIntrinsicWidth() : 0;
    }
}

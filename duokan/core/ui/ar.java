package com.duokan.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;

public class ar extends d {
    private Drawable b;
    private Drawable c;
    private Rect d;

    public ar(Context context) {
        this(context, null);
    }

    public ar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843037, 16843119, 16843120});
        this.b = obtainStyledAttributes.hasValue(1) ? obtainStyledAttributes.getDrawable(1) : this.b;
        this.c = obtainStyledAttributes.hasValue(2) ? obtainStyledAttributes.getDrawable(2) : this.c;
        obtainStyledAttributes.recycle();
    }

    public Drawable getLeftDrawable() {
        return this.b;
    }

    public void setLeftDrawable(Drawable drawable) {
        this.b = drawable;
        requestLayout();
    }

    public Drawable getRightDrawable() {
        return this.c;
    }

    public void setRightDrawable(Drawable drawable) {
        this.c = drawable;
        requestLayout();
    }

    protected void onDraw(Canvas canvas) {
        if (this.b != null) {
            this.d.set(0, 0, this.b.getIntrinsicWidth(), getHeight());
            if (this.a == ScaleType.CENTER) {
                this.d.inset(0, ((getHeight() - this.b.getIntrinsicHeight()) + 1) / 2);
            }
            canvas.save();
            canvas.clipRect(this.d);
            this.b.setBounds(this.d);
            this.b.draw(canvas);
            canvas.restore();
        }
        if (this.c != null) {
            this.d.set(getWidth() - this.c.getIntrinsicWidth(), 0, getWidth(), getHeight());
            if (this.a == ScaleType.CENTER) {
                this.d.inset(0, ((getHeight() - this.c.getIntrinsicHeight()) + 1) / 2);
            }
            canvas.save();
            canvas.clipRect(this.d);
            this.c.setBounds(this.d);
            this.c.draw(canvas);
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
        return this.b != null ? this.b.getIntrinsicWidth() : 0;
    }

    private int getRightDrawableWidth() {
        return this.c != null ? this.c.getIntrinsicWidth() : 0;
    }
}

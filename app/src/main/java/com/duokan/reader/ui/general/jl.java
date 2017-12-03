package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;

import com.duokan.core.ui.d;

public class jl extends d {
    private Drawable b;
    private Drawable c;
    private Rect d;

    public jl(Context context) {
        this(context, null);
    }

    public jl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843037, 16843119, 16843120});
        this.b = obtainStyledAttributes.hasValue(1) ? obtainStyledAttributes.getDrawable(1) : this.b;
        this.c = obtainStyledAttributes.hasValue(2) ? obtainStyledAttributes.getDrawable(2) : this.c;
        obtainStyledAttributes.recycle();
    }

    public Drawable getTopDrawable() {
        return this.b;
    }

    public void setTopDrawable(Drawable drawable) {
        this.b = drawable;
        requestLayout();
    }

    public Drawable getBottomDrawable() {
        return this.c;
    }

    public void setBottomDrawable(Drawable drawable) {
        this.c = drawable;
        requestLayout();
    }

    protected void onDraw(Canvas canvas) {
        if (this.b != null) {
            this.d.set(0, 0, getWidth(), this.b.getIntrinsicHeight());
            if (this.a == ScaleType.CENTER) {
                this.d.inset(((getWidth() - this.b.getIntrinsicWidth()) + 1) / 2, 0);
            }
            canvas.save();
            canvas.clipRect(this.d);
            this.b.setBounds(this.d);
            this.b.draw(canvas);
            canvas.restore();
        }
        if (this.c != null) {
            this.d.set(0, getHeight() - this.c.getIntrinsicHeight(), getWidth(), getHeight());
            if (this.a == ScaleType.CENTER) {
                this.d.inset(((getWidth() - this.b.getIntrinsicWidth()) + 1) / 2, 0);
            }
            canvas.save();
            canvas.clipRect(this.d);
            this.c.setBounds(this.d);
            this.c.draw(canvas);
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
        return this.b != null ? this.b.getIntrinsicHeight() : 0;
    }

    private int getBottomDrawableHeight() {
        return this.c != null ? this.c.getIntrinsicHeight() : 0;
    }
}

package com.duokan.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;

public abstract class d extends FrameLayout {
    protected ScaleType a = ScaleType.FIT_XY;

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843037});
        this.a = ScaleType.values()[obtainStyledAttributes.getInteger(0, this.a.ordinal())];
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
    }

    public ScaleType getScaleType() {
        return this.a;
    }

    public void setScaleType(ScaleType scaleType) {
        this.a = scaleType;
        requestLayout();
    }
}

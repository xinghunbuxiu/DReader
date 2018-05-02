package com.duokan.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;

/* renamed from: com.duokan.core.ui.d */
public abstract class C0377d extends FrameLayout {
    /* renamed from: a */
    protected ScaleType f968a = ScaleType.FIT_XY;

    public C0377d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843037});
        this.f968a = ScaleType.values()[obtainStyledAttributes.getInteger(0, this.f968a.ordinal())];
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
    }

    public ScaleType getScaleType() {
        return this.f968a;
    }

    public void setScaleType(ScaleType scaleType) {
        this.f968a = scaleType;
        requestLayout();
    }
}

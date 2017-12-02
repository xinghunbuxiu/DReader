package com.duokan.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class dn extends MarginLayoutParams {
    public int a;
    public int b;
    public int c;

    public dn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 17;
        this.b = 0;
        this.c = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842927});
        this.a = obtainStyledAttributes.getInteger(0, 17);
        obtainStyledAttributes.recycle();
    }

    public dn(int i, int i2, int i3) {
        this(i, i2, i3, 0, 0);
    }

    public dn(int i, int i2, int i3, int i4, int i5) {
        super(i, i2);
        this.a = 17;
        this.b = 0;
        this.c = 0;
        this.a = i3;
        this.b = i4;
        this.c = i5;
    }

    public dn(LayoutParams layoutParams) {
        super(layoutParams);
        this.a = 17;
        this.b = 0;
        this.c = 0;
        if (layoutParams instanceof dn) {
            dn dnVar = (dn) layoutParams;
            this.a = dnVar.a;
            this.b = dnVar.b;
            this.c = dnVar.c;
        }
    }
}

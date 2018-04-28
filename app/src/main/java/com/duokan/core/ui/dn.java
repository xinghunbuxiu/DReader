package com.duokan.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class dn extends MarginLayoutParams {
    /* renamed from: a */
    public int f1167a;
    /* renamed from: b */
    public int f1168b;
    /* renamed from: c */
    public int f1169c;

    public dn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1167a = 17;
        this.f1168b = 0;
        this.f1169c = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842927});
        this.f1167a = obtainStyledAttributes.getInteger(0, 17);
        obtainStyledAttributes.recycle();
    }

    public dn(int i, int i2, int i3) {
        this(i, i2, i3, 0, 0);
    }

    public dn(int i, int i2, int i3, int i4, int i5) {
        super(i, i2);
        this.f1167a = 17;
        this.f1168b = 0;
        this.f1169c = 0;
        this.f1167a = i3;
        this.f1168b = i4;
        this.f1169c = i5;
    }

    public dn(LayoutParams layoutParams) {
        super(layoutParams);
        this.f1167a = 17;
        this.f1168b = 0;
        this.f1169c = 0;
        if (layoutParams instanceof dn) {
            dn dnVar = (dn) layoutParams;
            this.f1167a = dnVar.f1167a;
            this.f1168b = dnVar.f1168b;
            this.f1169c = dnVar.f1169c;
        }
    }
}

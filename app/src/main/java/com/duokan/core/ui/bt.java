package com.duokan.core.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public abstract class bt extends LinearLayout {
    /* renamed from: a */
    public abstract int mo455a(View view, LayoutParams layoutParams);

    /* renamed from: a */
    public abstract View getTabView(int i);

    public abstract int getCellCount();

    public abstract ScaleType getDividerScaleType();

    public abstract Drawable getFirstDivider();

    public abstract Drawable getLastDivider();

    public abstract Drawable getMiddleDivider();

    public abstract void setDividerScaleType(ScaleType scaleType);

    public abstract void setFirstDivider(int i);

    public abstract void setFirstDivider(Drawable drawable);

    public abstract void setLastDivider(int i);

    public abstract void setLastDivider(Drawable drawable);

    public abstract void setMiddleDivider(int i);

    public abstract void setMiddleDivider(Drawable drawable);

    public bt(Context context) {
        this(context, null);
    }

    public bt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: b */
    public View m1321b(int i, TabBarView tabBarView) {
        return tabBarView.m1318e(i).getChildAt(0);
    }
}

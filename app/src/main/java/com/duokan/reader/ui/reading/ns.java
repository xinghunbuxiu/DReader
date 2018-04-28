package com.duokan.reader.ui.reading;

import android.content.Context;
import android.util.AttributeSet;
import com.duokan.core.ui.TabBarView;
import com.duokan.p024c.C0254f;

public class ns extends TabBarView {
    public ns(Context context) {
        this(context, null);
    }

    public ns(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setIndicatorGravity(119);
        setIndicatorDrawable(new nt(this, getResources().getDrawable(C0254f.reading__toc_view__bg2), getResources().getDrawable(C0254f.reading__toc_view__bg)));
    }

    /* renamed from: a */
    public void m14763a(float f) {
        super.m1323d(Math.round(((float) getPaddingLeft()) + (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * f)));
    }
}

package com.duokan.reader.ui.reading;

import android.content.Context;
import android.util.AttributeSet;

import com.duokan.c.f;
import com.duokan.core.ui.TabBarView;

public class ni extends TabBarView {
    public ni(Context context) {
        this(context, null);
    }

    public ni(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setIndicatorGravity(119);
        setIndicatorDrawable(new nj(this, getResources().getDrawable(f.reading__toc_view__bg2), getResources().getDrawable(f.reading__toc_view__bg)));
    }

    public void a(float f) {
        super.d(Math.round(((float) getPaddingLeft()) + (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * f)));
    }
}

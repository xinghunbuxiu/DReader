package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.lang.ref.WeakReference;

public class da extends MarginLayoutParams {
    /* renamed from: a */
    public final Rect f1126a = new Rect();
    /* renamed from: b */
    public WeakReference<View> f1127b = null;

    public da(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public da(int i, int i2) {
        super(i, i2);
    }

    public da(LayoutParams layoutParams) {
        super(layoutParams);
    }

    public da(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }
}

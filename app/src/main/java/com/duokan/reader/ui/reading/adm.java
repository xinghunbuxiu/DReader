package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;

import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0243e;
import com.duokan.reader.ui.general.en;

class adm extends FrameLayout {
    /* renamed from: a */
    private final FrameLayout f9522a;
    /* renamed from: b */
    private final FrameLayout f9523b;

    public adm(Context context, int i) {
        this(context, new ColorDrawable(i));
    }

    public adm(Context context, Drawable drawable) {
        super(context);
        this.f9522a = new FrameLayout(context);
        View enVar = new en(getContext());
        enVar.setBackgroundDrawable(drawable);
        enVar.setForeground(getResources().getDrawable(C0243e.reading__color_view__mask_small));
        this.f9522a.addView(enVar, new LayoutParams(AnimUtils.m1932b(getContext(), 32.0f), AnimUtils.m1932b(getContext(), 32.0f), 17));
        this.f9522a.setForeground(getResources().getDrawable(C0243e.reading__reading_options_view__icon_border_selected));
        this.f9522a.setForegroundGravity(17);
        addView(this.f9522a);
        this.f9523b = new FrameLayout(context);
        enVar = new en(getContext());
        enVar.setBackgroundDrawable(drawable);
        enVar.setForeground(getResources().getDrawable(C0243e.reading__color_view__mask));
        this.f9523b.addView(enVar, new LayoutParams(AnimUtils.m1932b(getContext(), 32.0f), AnimUtils.m1932b(getContext(), 32.0f), 17));
        addView(this.f9523b);
    }

    public void setSelected(boolean z) {
        int i;
        int i2 = 4;
        super.setSelected(z);
        FrameLayout frameLayout = this.f9522a;
        if (z) {
            i = 0;
        } else {
            i = 4;
        }
        frameLayout.setVisibility(i);
        FrameLayout frameLayout2 = this.f9523b;
        if (!z) {
            i2 = 0;
        }
        frameLayout2.setVisibility(i2);
    }
}

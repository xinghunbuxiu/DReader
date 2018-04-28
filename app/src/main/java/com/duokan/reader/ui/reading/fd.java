package com.duokan.reader.ui.reading;

import android.content.Context;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.p023b.C0242d;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ui.general.DkLabelView;

class fd extends adm {
    /* renamed from: a */
    private final DkLabelView f10135a = new DkLabelView(getContext());

    public fd(Context context, int i, int i2) {
        super(context, i);
        addView(this.f10135a, new LayoutParams(-2, -2, 17));
        this.f10135a.setTextSize(0, getResources().getDimension(C0242d.general_font__shared__e));
        this.f10135a.setIncludeFontPadding(false);
        this.f10135a.setTextColor(i2);
        this.f10135a.setText(getResources().getString(C0247i.reading__custom_theme_color_view__edit));
        this.f10135a.setGravity(17);
    }
}

package com.duokan.reader.ui.reading;

import android.content.Context;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.b.d;
import com.duokan.reader.ui.general.DkLabelView;

class ez extends acz {
    private final DkLabelView a = new DkLabelView(getContext());

    public ez(Context context, int i, int i2) {
        super(context, i);
        addView(this.a, new LayoutParams(-2, -2, 17));
        this.a.setTextSize(0, getResources().getDimension(d.general_font__shared__e));
        this.a.setIncludeFontPadding(false);
        this.a.setTextColor(i2);
        this.a.setText(getResources().getString(i.reading__custom_theme_color_view__edit));
        this.a.setGravity(17);
    }
}

package com.duokan.reader.ui.general;

import android.content.Context;
import android.widget.TextView;

class dv extends TextView {
    /* renamed from: a */
    final /* synthetic */ dr f7126a;

    dv(dr drVar, Context context) {
        this.f7126a = drVar;
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (MeasureSpec.getMode(i) != 1073741824) {
            super.onMeasure(MeasureSpec.makeMeasureSpec((int) ((((float) getText().length()) * getTextSize()) + ((float) com.duokan.core.ui.dv.m1932b(getContext(), 30.0f))), 1073741824), i2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setPadding(0, (this.f7126a.f7112j.getHeight() - com.duokan.core.ui.dv.m1932b(getContext(), 24.0f)) - com.duokan.core.ui.dv.getScaledDensity(getContext(), 14.0f), 0, 0);
    }
}

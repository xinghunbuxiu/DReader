package com.duokan.reader.ui.general;

import android.content.Context;
import android.widget.TextView;

import com.duokan.core.ui.UTools;

class dw extends TextView {
    final /* synthetic */ ds a;

    dw(ds dsVar, Context context) {
        this.a = dsVar;
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (MeasureSpec.getMode(i) != 1073741824) {
            super.onMeasure(MeasureSpec.makeMeasureSpec((int) ((((float) getText().length()) * getTextSize()) + ((float) UTools.getMinimumHeight(getContext(), 30.0f))), 1073741824), i2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setPadding(getPaddingLeft(), Math.max(0, (this.a.d - this.a.c) - this.a.getTabTextHeight()), getPaddingRight(), getPaddingBottom());
    }
}

package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import com.duokan.p023b.C0241c;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.dk;
import com.duokan.reader.ui.general.eg;

public class kf extends DkWebListView {
    public kf(Context context) {
        this(context, null);
    }

    public kf(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundColor(getResources().getColor(C0241c.general__shared__ffffff));
        setRowDivider(new InsetDrawable(new dk(getResources().getColor(C0241c.general__shared__cccccc)), 0, 0, 0, 0));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 != i) {
            setNumColumns(eg.m10551a(getContext(), i));
        }
    }
}

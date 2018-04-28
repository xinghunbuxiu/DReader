package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.duokan.core.ui.bk;
import com.duokan.p023b.C0243e;

public class TabView extends bk {
    public TabView(Context context) {
        this(context, null);
    }

    public TabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842964});
        if (!obtainStyledAttributes.hasValue(0)) {
            setBackgroundResource(C0243e.general__shared__tab_default);
        }
        obtainStyledAttributes.recycle();
        setSelectAnimateEnable(false);
    }
}

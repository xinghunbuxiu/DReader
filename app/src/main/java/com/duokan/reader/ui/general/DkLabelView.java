package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class DkLabelView extends TextView {

    public enum ContentMode {
        DEFAULT,
        ZH_CN,
        EN,
        NUM
    }

    public DkLabelView(Context context) {
        this(context, null);
    }

    public DkLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setContentMode(ContentMode contentMode) {
    }
}

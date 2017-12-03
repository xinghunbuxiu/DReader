package com.duokan.reader.ui.general;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;


public class DkLabelView extends AppCompatTextView {

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

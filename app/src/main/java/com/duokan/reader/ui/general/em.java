package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import com.duokan.core.ui.BaseDialog;

public class em extends BaseDialog {
    public em(Context context) {
        super(context);
        setContentView(new LoadingCircleView(context), new LayoutParams(-2, -2));
        setGravity(17);
        setDimAmount(0.0f);
    }
}

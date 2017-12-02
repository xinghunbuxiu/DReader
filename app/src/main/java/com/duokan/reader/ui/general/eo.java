package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;

import com.duokan.core.ui.j;

public class eo extends j {
    public eo(Context context) {
        super(context);
        setContentView(new LoadingCircleView(context), new LayoutParams(-2, -2));
        setGravity(17);
        setDimAmount(0.0f);
    }
}

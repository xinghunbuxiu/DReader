package com.duokan.core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class t extends f {
    public t(Context context) {
        super(context);
        setGravity(119);
        setDimAmount(0.0f);
    }

    public void setContentView(View view) {
        setContentView(view, view.getLayoutParams() != null ? view.getLayoutParams() : new LayoutParams(-1, -1));
    }
}

package com.duokan.core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* renamed from: com.duokan.core.ui.t */
public class C0394t extends C0343f {
    public C0394t(Context context) {
        super(context);
        setGravity(119);
        setDimAmount(0.0f);
    }

    public void setContentView(View view) {
        setContentView(view, view.getLayoutParams() != null ? view.getLayoutParams() : new LayoutParams(-1, -1));
    }
}

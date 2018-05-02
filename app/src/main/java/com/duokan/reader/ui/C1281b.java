package com.duokan.reader.ui;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* renamed from: com.duokan.reader.ui.b */
class C1281b implements OnApplyWindowInsetsListener {
    /* renamed from: a */
    final /* synthetic */ C1235a f6014a;

    C1281b(C1235a c1235a) {
        this.f6014a = c1235a;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        int systemWindowInsetLeft = windowInsets.getSystemWindowInsetLeft();
        windowInsets.getSystemWindowInsetTop();
        int systemWindowInsetRight = windowInsets.getSystemWindowInsetRight();
        this.f6014a.m8805a(windowInsets.getSystemWindowInsetBottom());
        return windowInsets.replaceSystemWindowInsets(systemWindowInsetLeft, 0, systemWindowInsetRight, 0);
    }
}

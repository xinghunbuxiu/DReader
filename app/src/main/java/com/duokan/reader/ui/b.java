package com.duokan.reader.ui;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

class b implements OnApplyWindowInsetsListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        int systemWindowInsetLeft = windowInsets.getSystemWindowInsetLeft();
        windowInsets.getSystemWindowInsetTop();
        int systemWindowInsetRight = windowInsets.getSystemWindowInsetRight();
        this.a.a(windowInsets.getSystemWindowInsetBottom());
        return windowInsets.replaceSystemWindowInsets(systemWindowInsetLeft, 0, systemWindowInsetRight, 0);
    }
}

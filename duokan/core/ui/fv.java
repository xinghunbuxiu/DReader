package com.duokan.core.ui;

import android.webkit.WebChromeClient.CustomViewCallback;

class fv implements fo {
    final /* synthetic */ CustomViewCallback a;
    final /* synthetic */ fu b;

    fv(fu fuVar, CustomViewCallback customViewCallback) {
        this.b = fuVar;
        this.a = customViewCallback;
    }

    public void a() {
        this.a.onCustomViewHidden();
    }
}

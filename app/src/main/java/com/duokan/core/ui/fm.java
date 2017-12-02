package com.duokan.core.ui;

import android.webkit.WebChromeClient.CustomViewCallback;

class fm implements CustomViewCallback {
    final /* synthetic */ fo a;
    final /* synthetic */ fl b;

    fm(fl flVar, fo foVar) {
        this.b = flVar;
        this.a = foVar;
    }

    public void onCustomViewHidden() {
        this.a.a();
    }
}

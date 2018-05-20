package com.duokan.core.ui;

import android.webkit.WebChromeClient.CustomViewCallback;

class fm implements CustomViewCallback {
    /* renamed from: a */
    final /* synthetic */ fo f1257a;
    /* renamed from: b */
    final /* synthetic */ WebPageChromeClient f1258b;

    fm(WebPageChromeClient webPageChromeClient, fo foVar) {
        this.f1258b = webPageChromeClient;
        this.f1257a = foVar;
    }

    public void onCustomViewHidden() {
        this.f1257a.mo530a();
    }
}

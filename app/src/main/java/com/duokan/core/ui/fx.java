package com.duokan.core.ui;

import android.webkit.WebChromeClient.CustomViewCallback;

class fx implements fo {
    /* renamed from: a */
    final /* synthetic */ CustomViewCallback f1277a;
    /* renamed from: b */
    final /* synthetic */ fw f1278b;

    fx(fw fwVar, CustomViewCallback customViewCallback) {
        this.f1278b = fwVar;
        this.f1277a = customViewCallback;
    }

    /* renamed from: a */
    public void mo530a() {
        this.f1277a.onCustomViewHidden();
    }
}

package com.duokan.reader.ui.general.web;

import java.util.concurrent.Callable;

class bo implements Callable<String> {
    /* renamed from: a */
    final /* synthetic */ StorePageController f7636a;

    bo(StorePageController storePageController) {
        this.f7636a = storePageController;
    }

    public /* synthetic */ Object call() {
        return m11054a();
    }

    /* renamed from: a */
    public String m11054a() {
        return this.f7636a.mWebView.getCurrentUrl();
    }
}

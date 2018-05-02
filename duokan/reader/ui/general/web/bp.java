package com.duokan.reader.ui.general.web;

import java.util.concurrent.Callable;

class bp implements Callable {
    final /* synthetic */ StorePageController a;

    bp(StorePageController storePageController) {
        this.a = storePageController;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public String a() {
        return this.a.mWebView.getCurrentUrl();
    }
}

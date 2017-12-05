package com.duokan.reader.ui.general.web;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.h;

class cc implements h {
    final /* synthetic */ StorePageController a;

    cc(StorePageController storePageController) {
        this.a = storePageController;
    }

    public void a(a aVar) {
    }

    public void b(a aVar) {
        WebLog.c().WebLog();
        if (StorePageController.sPreloadedController != null) {
            StorePageController.sPreloadedController.mWebView.f();
            StorePageController.sPreloadedController = null;
        }
    }

    public void c(a aVar) {
        WebLog.c().WebLog();
        if (StorePageController.sPreloadedController != null) {
            StorePageController.sPreloadedController.mWebView.f();
            StorePageController.sPreloadedController = null;
        }
    }

    public void d(a aVar) {
    }
}

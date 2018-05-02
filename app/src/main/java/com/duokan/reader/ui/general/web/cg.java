package com.duokan.reader.ui.general.web;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;

public class cg implements C0586j {
    public void onAccountLoginedTopHalf(C0672a c0672a) {
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        WebLog.init().w();
        if (StorePageController.sPreloadedController != null) {
            StorePageController.sPreloadedController.mWebView.mo1821f();
            StorePageController.sPreloadedController = null;
        }
    }

    public void onAccountLogoff(C0672a c0672a) {
        WebLog.init().w();
        if (StorePageController.sPreloadedController != null) {
            StorePageController.sPreloadedController.mWebView.mo1821f();
            StorePageController.sPreloadedController = null;
        }
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }
}

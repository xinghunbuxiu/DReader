package com.duokan.reader.ui.general.web;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.app.w;
import com.duokan.core.diagnostic.a;

class cb implements w {
    final /* synthetic */ StorePageController a;

    cb(StorePageController storePageController) {
        this.a = storePageController;
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        a.c().a();
        if (runningState2 != RunningState.FOREGROUND && StorePageController.sPreloadedController != null) {
            StorePageController.sPreloadedController.mWebView.f();
            StorePageController.sPreloadedController = null;
        }
    }
}

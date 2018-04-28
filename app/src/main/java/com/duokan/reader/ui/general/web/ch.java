package com.duokan.reader.ui.general.web;

import com.duokan.core.app.C0286x;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.diagnostic.C0328a;

public class ch implements C0286x {
    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        C0328a.m757c().m760a();
        if (runningState2 != RunningState.FOREGROUND && StorePageController.sPreloadedController != null) {
            StorePageController.sPreloadedController.mWebView.mo1821f();
            StorePageController.sPreloadedController = null;
        }
    }
}

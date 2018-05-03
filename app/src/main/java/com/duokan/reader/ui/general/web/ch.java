package com.duokan.reader.ui.general.web;

import com.duokan.core.app.ApplicationsStateCallbacks;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.diagnostic.WebLog;

public class ch implements ApplicationsStateCallbacks {
    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        WebLog.init().w();
        if (runningState2 != RunningState.FOREGROUND && StorePageController.sPreloadedController != null) {
            StorePageController.sPreloadedController.mWebView.mo1821f();
            StorePageController.sPreloadedController = null;
        }
    }
}

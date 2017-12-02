package com.duokan.reader.ui.general.web;

import android.app.Activity;

import com.duokan.core.sys.s;
import com.duokan.reader.common.webservices.duokan.p;

class cd implements s {
    final /* synthetic */ StorePageController a;

    cd(StorePageController storePageController) {
        this.a = storePageController;
    }

    public boolean idleRun() {
        if (StorePageController.sPreloadedController == null) {
            Activity activity = this.a.getActivity();
            if (!(activity == null || activity.isFinishing())) {
                StorePageController.sPreloadedController = new StorePageController(this.a.getContext());
                StorePageController.sPreloadedController.loadUrl(p.i().a());
            }
        }
        return false;
    }
}

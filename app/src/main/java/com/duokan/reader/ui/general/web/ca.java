package com.duokan.reader.ui.general.web;

import com.duokan.core.app.AppManage;
import com.duokan.core.sys.IdleHandlerListener;
import com.duokan.reader.common.webservices.duokan.C0641o;

class ca implements IdleHandlerListener {
    /* renamed from: a */
    final /* synthetic */ StorePageController f7659a;

    ca(StorePageController storePageController) {
        this.f7659a = storePageController;
    }

    public boolean idleRun() {
        if (StorePageController.sPreloadedController == null && AppManage.isFinishing(this.f7659a.getActivity())) {
            StorePageController.sPreloadedController = new StorePageController(this.f7659a.getContext());
            StorePageController.sPreloadedController.loadUrl(C0641o.m2934i().m2952a());
        }
        return false;
    }
}

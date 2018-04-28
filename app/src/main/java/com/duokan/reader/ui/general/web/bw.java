package com.duokan.reader.ui.general.web;

import com.duokan.core.app.C0301c;
import com.duokan.core.app.OnCancelListener;

class bw implements OnCancelListener {
    /* renamed from: a */
    final /* synthetic */ StorePageController f7651a;

    bw(StorePageController storePageController) {
        this.f7651a = storePageController;
    }

    public void onCancel(C0301c c0301c) {
        if (this.f7651a.webPageLoading()) {
            this.f7651a.requestDetach();
        }
    }
}

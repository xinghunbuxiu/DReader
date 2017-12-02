package com.duokan.reader.ui.general.web;

import com.duokan.core.app.c;
import com.duokan.core.app.d;

class bx implements d {
    final /* synthetic */ StorePageController a;

    bx(StorePageController storePageController) {
        this.a = storePageController;
    }

    public void onCancel(c cVar) {
        if (this.a.webPageLoading()) {
            this.a.requestDetach();
        }
    }
}

package com.duokan.reader.ui.general.web;

class bn implements Runnable {
    /* renamed from: a */
    final /* synthetic */ StorePageController f7635a;

    bn(StorePageController storePageController) {
        this.f7635a = storePageController;
    }

    public void run() {
        this.f7635a.requestDetach();
        this.f7635a.mErrorDialog = null;
    }
}

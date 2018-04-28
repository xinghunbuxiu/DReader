package com.duokan.reader.ui.general.web;

class bm implements Runnable {
    /* renamed from: a */
    final /* synthetic */ StorePageController f7634a;

    bm(StorePageController storePageController) {
        this.f7634a = storePageController;
    }

    public void run() {
        this.f7634a.refresh();
        this.f7634a.mErrorDialog = null;
    }
}

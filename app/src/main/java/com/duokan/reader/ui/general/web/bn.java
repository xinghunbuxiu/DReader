package com.duokan.reader.ui.general.web;

class bn implements Runnable {
    final /* synthetic */ StorePageController a;

    bn(StorePageController storePageController) {
        this.a = storePageController;
    }

    public void run() {
        this.a.refresh();
        this.a.mErrorDialog = null;
    }
}

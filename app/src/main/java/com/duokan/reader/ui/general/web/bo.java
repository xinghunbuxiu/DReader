package com.duokan.reader.ui.general.web;

class bo implements Runnable {
    final /* synthetic */ StorePageController a;

    bo(StorePageController storePageController) {
        this.a = storePageController;
    }

    public void run() {
        this.a.requestDetach();
        this.a.mErrorDialog = null;
    }
}

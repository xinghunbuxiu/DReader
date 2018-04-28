package com.duokan.reader.ui.general.web;

class bc implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f7618a;
    /* renamed from: b */
    final /* synthetic */ StorePageController f7619b;

    bc(StorePageController storePageController, String str) {
        this.f7619b = storePageController;
        this.f7618a = str;
    }

    public void run() {
        this.f7619b.queryBookDetail(this.f7618a, true, new bd(this), true);
    }
}

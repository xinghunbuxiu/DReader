package com.duokan.reader.ui.general.web;

class az implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f7613a;
    /* renamed from: b */
    final /* synthetic */ StorePageController f7614b;

    az(StorePageController storePageController, String str) {
        this.f7614b = storePageController;
        this.f7613a = str;
    }

    public void run() {
        this.f7614b.queryBookDetail(this.f7613a, new ba(this), true);
    }
}

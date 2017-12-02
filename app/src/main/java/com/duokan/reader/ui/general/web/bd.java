package com.duokan.reader.ui.general.web;

class bd implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ StorePageController b;

    bd(StorePageController storePageController, String str) {
        this.b = storePageController;
        this.a = str;
    }

    public void run() {
        this.b.queryBookDetail(this.a, true, new be(this), true);
    }
}

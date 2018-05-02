package com.duokan.reader.ui.general.web;

class ba implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ StorePageController b;

    ba(StorePageController storePageController, String str) {
        this.b = storePageController;
        this.a = str;
    }

    public void run() {
        this.b.queryBookDetail(this.a, new bb(this), true);
    }
}

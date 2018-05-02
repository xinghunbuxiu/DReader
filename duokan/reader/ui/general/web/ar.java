package com.duokan.reader.ui.general.web;

class ar implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;
    final /* synthetic */ StorePageController c;

    ar(StorePageController storePageController, String str, boolean z) {
        this.c = storePageController;
        this.a = str;
        this.b = z;
    }

    public void run() {
        this.c.queryFictionDetail(this.a, new as(this), true);
    }
}

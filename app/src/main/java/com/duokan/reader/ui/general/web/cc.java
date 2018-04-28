package com.duokan.reader.ui.general.web;

class cc implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f7663a;
    /* renamed from: b */
    final /* synthetic */ boolean f7664b;
    /* renamed from: c */
    final /* synthetic */ StorePageController f7665c;

    cc(StorePageController storePageController, String str, boolean z) {
        this.f7665c = storePageController;
        this.f7663a = str;
        this.f7664b = z;
    }

    public void run() {
        this.f7665c.queryFictionDetail(this.f7663a, new cd(this), true);
    }
}

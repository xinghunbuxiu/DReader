package com.duokan.reader.ui.surfing;

import com.duokan.reader.ui.general.web.StorePageController;

class ab implements Runnable {
    /* renamed from: a */
    final /* synthetic */ StorePageController f11500a;
    /* renamed from: b */
    final /* synthetic */ C1522i f11501b;

    ab(C1522i c1522i, StorePageController storePageController) {
        this.f11501b = c1522i;
        this.f11500a = storePageController;
    }

    public void run() {
        this.f11501b.showPopup(this.f11500a);
    }
}

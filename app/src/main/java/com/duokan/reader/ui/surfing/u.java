package com.duokan.reader.ui.surfing;

import com.duokan.reader.ui.general.web.StorePageController;

class u implements Runnable {
    final /* synthetic */ StorePageController a;
    final /* synthetic */ f b;

    u(f fVar, StorePageController storePageController) {
        this.b = fVar;
        this.a = storePageController;
    }

    public void run() {
        this.b.showPopup(this.a);
    }
}

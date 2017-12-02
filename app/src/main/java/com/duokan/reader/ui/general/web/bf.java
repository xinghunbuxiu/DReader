package com.duokan.reader.ui.general.web;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.store.j;

class bf implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ StorePageController b;

    bf(StorePageController storePageController, String str) {
        this.b = storePageController;
        this.a = str;
    }

    public void run() {
        ((ReaderFeature) this.b.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new j(this.b.getContext(), this.a), null);
    }
}

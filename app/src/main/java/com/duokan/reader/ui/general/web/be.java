package com.duokan.reader.ui.general.web;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.store.C1497j;

class be implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f7621a;
    /* renamed from: b */
    final /* synthetic */ StorePageController f7622b;

    be(StorePageController storePageController, String str) {
        this.f7622b = storePageController;
        this.f7621a = str;
    }

    public void run() {
        ((ReaderFeature) this.f7622b.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new C1497j(this.f7622b.getContext(), this.f7621a), null);
    }
}

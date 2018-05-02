package com.duokan.reader.ui.general.web;

import com.duokan.core.app.c;
import com.duokan.core.app.d;
import com.mipay.sdk.Mipay;

class au implements d {
    final /* synthetic */ String a;
    final /* synthetic */ StorePageController b;

    au(StorePageController storePageController, String str) {
        this.b = storePageController;
        this.a = str;
    }

    public void onCancel(c cVar) {
        this.b.web_notifyWeb(this.a, 2, Mipay.KEY_RESULT, Integer.valueOf(2));
    }
}

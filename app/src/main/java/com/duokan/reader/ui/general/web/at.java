package com.duokan.reader.ui.general.web;

import com.duokan.core.app.C0301c;
import com.duokan.core.app.OnCancelListener;
import com.mipay.sdk.Mipay;

class at implements OnCancelListener {
    /* renamed from: a */
    final /* synthetic */ String f7596a;
    /* renamed from: b */
    final /* synthetic */ StorePageController f7597b;

    at(StorePageController storePageController, String str) {
        this.f7597b = storePageController;
        this.f7596a = str;
    }

    public void onCancel(C0301c c0301c) {
        this.f7597b.web_notifyWeb(this.f7596a, 2, Mipay.KEY_RESULT, Integer.valueOf(2));
    }
}

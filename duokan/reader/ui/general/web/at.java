package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.af;
import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.ui.general.ib;
import com.mipay.sdk.Mipay;

class at implements ib {
    final /* synthetic */ fv a;
    final /* synthetic */ String b;
    final /* synthetic */ StorePageController c;

    at(StorePageController storePageController, fv fvVar, String str) {
        this.c = storePageController;
        this.a = fvVar;
        this.b = str;
    }

    public void a(int i) {
        if (i == 0) {
            this.a.a(false, new af(Boolean.valueOf(false)));
        } else {
            this.a.a(true, new af(Boolean.valueOf(false)));
        }
        this.c.web_notifyWeb(this.b, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
    }
}

package com.duokan.reader.ui.general.web;

import com.duokan.core.app.af;
import com.duokan.core.app.ag;
import com.duokan.reader.domain.bookshelf.fv;
import com.mipay.sdk.Mipay;

class av implements ag {
    final /* synthetic */ fv a;
    final /* synthetic */ String b;
    final /* synthetic */ StorePageController c;

    av(StorePageController storePageController, fv fvVar, String str) {
        this.c = storePageController;
        this.a = fvVar;
        this.b = str;
    }

    public void a(af afVar) {
        this.a.a(true, new com.duokan.core.sys.af(Boolean.valueOf(false)));
        this.c.web_notifyWeb(this.b, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
    }

    public void b(af afVar) {
        this.c.web_notifyWeb(this.b, 2, Mipay.KEY_RESULT, Integer.valueOf(2));
    }

    public void c(af afVar) {
        this.c.web_notifyWeb(this.b, 2, Mipay.KEY_RESULT, Integer.valueOf(2));
    }
}

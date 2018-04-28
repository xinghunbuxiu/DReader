package com.duokan.reader.ui.general.web;

import com.duokan.core.app.ag;
import com.duokan.core.app.ah;
import com.duokan.core.sys.af;
import com.duokan.reader.domain.bookshelf.fp;
import com.mipay.sdk.Mipay;

class au implements ah {
    /* renamed from: a */
    final /* synthetic */ fp f7598a;
    /* renamed from: b */
    final /* synthetic */ String f7599b;
    /* renamed from: c */
    final /* synthetic */ StorePageController f7600c;

    au(StorePageController storePageController, fp fpVar, String str) {
        this.f7600c = storePageController;
        this.f7598a = fpVar;
        this.f7599b = str;
    }

    /* renamed from: a */
    public void mo1562a(ag agVar) {
        this.f7598a.m4201a(true, new af(Boolean.valueOf(false)));
        this.f7600c.web_notifyWeb(this.f7599b, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
    }

    /* renamed from: b */
    public void mo1567b(ag agVar) {
        this.f7600c.web_notifyWeb(this.f7599b, 2, Mipay.KEY_RESULT, Integer.valueOf(2));
    }

    /* renamed from: c */
    public void mo1565c(ag agVar) {
        this.f7600c.web_notifyWeb(this.f7599b, 2, Mipay.KEY_RESULT, Integer.valueOf(2));
    }
}

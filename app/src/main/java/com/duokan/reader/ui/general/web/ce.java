package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.af;
import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.ui.general.hq;
import com.mipay.sdk.Mipay;

class ce implements hq {
    /* renamed from: a */
    final /* synthetic */ fp f7667a;
    /* renamed from: b */
    final /* synthetic */ String f7668b;
    /* renamed from: c */
    final /* synthetic */ StorePageController f7669c;

    ce(StorePageController storePageController, fp fpVar, String str) {
        this.f7669c = storePageController;
        this.f7667a = fpVar;
        this.f7668b = str;
    }

    /* renamed from: a */
    public void mo1590a(int i) {
        if (i == 0) {
            this.f7667a.m4201a(false, new af(Boolean.valueOf(false)));
        } else {
            this.f7667a.m4201a(true, new af(Boolean.valueOf(false)));
        }
        this.f7669c.web_notifyWeb(this.f7668b, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
    }
}

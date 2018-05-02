package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.mipay.sdk.Mipay;

class ih implements ag {
    final /* synthetic */ String a;
    final /* synthetic */ ig b;

    ih(ig igVar, String str) {
        this.b = igVar;
        this.a = str;
    }

    public void a(DkStoreFictionDetail dkStoreFictionDetail) {
        this.b.b.pageController.web_notifyWeb(this.a, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
    }
}

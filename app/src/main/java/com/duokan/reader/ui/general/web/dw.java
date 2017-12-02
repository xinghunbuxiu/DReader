package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.b;
import com.mipay.sdk.Mipay;

class dw implements b {
    final /* synthetic */ dv a;

    dw(dv dvVar) {
        this.a = dvVar;
    }

    public void a(a aVar) {
        this.a.b.b.a(this.a.a, aVar);
    }

    public void a(a aVar, String str) {
        this.a.b.b.b.web_notifyWeb(this.a.a, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
    }
}

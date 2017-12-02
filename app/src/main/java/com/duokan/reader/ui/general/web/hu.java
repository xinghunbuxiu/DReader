package com.duokan.reader.ui.general.web;

import com.duokan.reader.ui.account.ce;
import com.mipay.sdk.Mipay;

class hu implements ce {
    final /* synthetic */ ht a;

    hu(ht htVar) {
        this.a = htVar;
    }

    public void a(String str) {
        this.a.m.b.b.web_notifyWeb(this.a.a, 0, Mipay.KEY_RESULT, Integer.valueOf(0), "msg", str);
    }

    public void b(String str) {
        this.a.m.b.b.web_notifyWeb(this.a.a, 2, Mipay.KEY_RESULT, Integer.valueOf(2), "msg", str);
    }

    public void c(String str) {
        this.a.m.b.b.web_notifyWeb(this.a.a, 4, Mipay.KEY_RESULT, Integer.valueOf(4), "msg", str);
    }
}

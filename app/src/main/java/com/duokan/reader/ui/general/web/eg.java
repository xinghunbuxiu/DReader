package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.C0672a;
import com.mipay.sdk.Mipay;

class eg implements C0420b {
    /* renamed from: a */
    final /* synthetic */ ef f7770a;

    eg(ef efVar) {
        this.f7770a = efVar;
    }

    public void onLoginOk(C0672a c0672a) {
        this.f7770a.f7769b.f7767b.m11008a(this.f7770a.f7768a, c0672a);
    }

    public void onLoginError(C0672a c0672a, String str) {
        this.f7770a.f7769b.f7767b.f7581b.web_notifyWeb(this.f7770a.f7768a, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
    }
}

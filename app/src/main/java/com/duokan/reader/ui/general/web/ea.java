package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.C0672a;
import com.mipay.sdk.Mipay;

class ea implements C0420b {
    /* renamed from: a */
    final /* synthetic */ dz f7760a;

    ea(dz dzVar) {
        this.f7760a = dzVar;
    }

    public void onLoginOk(C0672a c0672a) {
        this.f7760a.f7756b.f7754b.m11008a(this.f7760a.f7755a, c0672a);
    }

    public void onLoginError(C0672a c0672a, String str) {
        this.f7760a.f7756b.f7754b.f7581b.web_notifyWeb(this.f7760a.f7755a, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
    }
}

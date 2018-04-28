package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.C0672a;
import com.mipay.sdk.Mipay;

class ed implements C0420b {
    /* renamed from: a */
    final /* synthetic */ ec f7765a;

    ed(ec ecVar) {
        this.f7765a = ecVar;
    }

    public void onLoginOk(C0672a c0672a) {
        this.f7765a.f7764b.f7762b.m11008a(this.f7765a.f7763a, c0672a);
    }

    public void onLoginError(C0672a c0672a, String str) {
        this.f7765a.f7764b.f7762b.f7581b.web_notifyWeb(this.f7765a.f7763a, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
    }
}

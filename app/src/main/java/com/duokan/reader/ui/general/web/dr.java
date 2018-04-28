package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.C0672a;
import com.mipay.sdk.Mipay;

class dr implements C0420b {
    /* renamed from: a */
    final /* synthetic */ dq f7743a;

    dr(dq dqVar) {
        this.f7743a = dqVar;
    }

    public void onLoginOk(C0672a c0672a) {
        this.f7743a.f7742b.f7740b.m11008a(this.f7743a.f7741a, c0672a);
    }

    public void onLoginError(C0672a c0672a, String str) {
        this.f7743a.f7742b.f7740b.f7581b.web_notifyWeb(this.f7743a.f7741a, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
    }
}

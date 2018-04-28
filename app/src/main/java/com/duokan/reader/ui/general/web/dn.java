package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.C0672a;
import com.mipay.sdk.Mipay;

class dn implements C0420b {
    /* renamed from: a */
    final /* synthetic */ dm f7737a;

    dn(dm dmVar) {
        this.f7737a = dmVar;
    }

    public void onLoginOk(C0672a c0672a) {
        this.f7737a.f7736b.f7734b.m11008a(this.f7737a.f7735a, c0672a);
    }

    public void onLoginError(C0672a c0672a, String str) {
        this.f7737a.f7736b.f7734b.f7581b.web_notifyWeb(this.f7737a.f7735a, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
    }
}

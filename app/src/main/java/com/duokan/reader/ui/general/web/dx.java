package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.mipay.sdk.Mipay;

class dx implements C0666x {
    /* renamed from: a */
    final /* synthetic */ dw f7752a;

    dx(dw dwVar) {
        this.f7752a = dwVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f7752a.f7751b.f7749b.m11008a(this.f7752a.f7750a, c0672a);
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f7752a.f7751b.f7749b.f7581b.web_notifyWeb(this.f7752a.f7750a, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
    }
}

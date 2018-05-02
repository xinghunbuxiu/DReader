package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.mipay.sdk.Mipay;

/* renamed from: com.duokan.reader.ui.general.web.do */
class C1356do implements C0666x {
    /* renamed from: a */
    final /* synthetic */ dm f7738a;

    C1356do(dm dmVar) {
        this.f7738a = dmVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f7738a.f7736b.f7734b.m11008a(this.f7738a.f7735a, c0672a);
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f7738a.f7736b.f7734b.f7581b.web_notifyWeb(this.f7738a.f7735a, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
    }
}

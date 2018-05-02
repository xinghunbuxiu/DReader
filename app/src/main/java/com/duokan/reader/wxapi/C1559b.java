package com.duokan.reader.wxapi;

import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* renamed from: com.duokan.reader.wxapi.b */
class C1559b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ WXPayEntryActivity f11631a;

    C1559b(WXPayEntryActivity wXPayEntryActivity) {
        this.f11631a = wXPayEntryActivity;
    }

    public void run() {
        this.f11631a.f11629a = WXAPIFactory.createWXAPI(this.f11631a, ThirdWeiXin.getAppKey());
        this.f11631a.f11629a.handleIntent(this.f11631a.getIntent(), this.f11631a);
    }
}

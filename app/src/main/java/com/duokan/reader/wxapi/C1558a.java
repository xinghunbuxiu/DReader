package com.duokan.reader.wxapi;

import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* renamed from: com.duokan.reader.wxapi.a */
class C1558a implements Runnable {
    /* renamed from: a */
    final /* synthetic */ WXEntryActivity f11630a;

    C1558a(WXEntryActivity wXEntryActivity) {
        this.f11630a = wXEntryActivity;
    }

    public void run() {
        this.f11630a.f11628a = WXAPIFactory.createWXAPI(this.f11630a, ThirdWeiXin.getAppKey(), true);
        this.f11630a.f11628a.handleIntent(this.f11630a.getIntent(), this.f11630a);
    }
}

package com.duokan.reader.wxapi;

import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

class a implements Runnable {
    final /* synthetic */ WXEntryActivity a;

    a(WXEntryActivity wXEntryActivity) {
        this.a = wXEntryActivity;
    }

    public void run() {
        this.a.a = WXAPIFactory.createWXAPI(this.a, ThirdWeiXin.getAppKey(), true);
        this.a.a.handleIntent(this.a.getIntent(), this.a);
    }
}

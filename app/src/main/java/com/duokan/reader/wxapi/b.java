package com.duokan.reader.wxapi;

import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

class b implements Runnable {
    final /* synthetic */ WXPayEntryActivity a;

    b(WXPayEntryActivity wXPayEntryActivity) {
        this.a = wXPayEntryActivity;
    }

    public void run() {
        this.a.a = WXAPIFactory.createWXAPI(this.a, ThirdWeiXin.getAppKey());
        this.a.a.handleIntent(this.a.getIntent(), this.a);
    }
}

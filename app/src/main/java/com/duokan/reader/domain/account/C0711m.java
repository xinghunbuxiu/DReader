package com.duokan.reader.domain.account;

import com.tencent.mm.opensdk.modelmsg.SendAuth$Resp;

/* renamed from: com.duokan.reader.domain.account.m */
class C0711m implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0709k f2488a;

    C0711m(C0709k c0709k) {
        this.f2488a = c0709k;
    }

    public void run() {
        SendAuth$Resp sendAuth$Resp = new SendAuth$Resp();
        sendAuth$Resp.code = null;
        this.f2488a.m3496a(sendAuth$Resp);
    }
}

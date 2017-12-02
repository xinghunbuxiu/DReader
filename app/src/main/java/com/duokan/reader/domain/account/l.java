package com.duokan.reader.domain.account;

import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;

class l implements Runnable {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public void run() {
        Resp resp = new Resp();
        resp.code = null;
        this.a.a.a(resp);
    }
}

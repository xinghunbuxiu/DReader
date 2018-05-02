package com.duokan.reader.domain.account;

import com.tencent.mm.opensdk.modelmsg.SendAuth.SendAuth$Resp;

class l implements Runnable {
    final /* synthetic */ LifeEvent a;

    l(LifeEvent kVar) {
        this.a = kVar;
    }

    public void run() {
        Resp resp = new Resp();
        resp.code = null;
        this.a.a.a(resp);
    }
}

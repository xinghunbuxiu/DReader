package com.duokan.reader.domain.micloud;

import cn.kuaipan.android.kss.KssMaster.IRemote;

class g implements IRemote {
    final /* synthetic */ d a;

    private g(d dVar) {
        this.a = dVar;
    }

    public String getIdentity() {
        return "CreateFileTask_" + ((i) this.a.b()).N() + "_" + ((i) this.a.b()).O() + "_" + ((i) this.a.b()).w();
    }
}

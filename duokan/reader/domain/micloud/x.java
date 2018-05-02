package com.duokan.reader.domain.micloud;

import cn.kuaipan.android.kss.KssMaster.IRemote;

class x implements IRemote {
    final /* synthetic */ u a;

    private x(u uVar) {
        this.a = uVar;
    }

    public String getIdentity() {
        return "DownloadFileTask_" + ((z) this.a.b()).N() + "_" + ((z) this.a.b()).O() + "_" + ((z) this.a.b()).y();
    }
}

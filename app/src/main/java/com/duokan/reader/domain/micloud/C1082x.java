package com.duokan.reader.domain.micloud;

import cn.kuaipan.android.kss.KssMaster.IRemote;

/* renamed from: com.duokan.reader.domain.micloud.x */
class C1082x implements IRemote {
    /* renamed from: a */
    final /* synthetic */ C1079u f5306a;

    private C1082x(C1079u c1079u) {
        this.f5306a = c1079u;
    }

    public String getIdentity() {
        return "DownloadFileTask_" + ((C1084z) this.f5306a.mo734b()).m8140N() + "_" + ((C1084z) this.f5306a.mo734b()).m8141O() + "_" + ((C1084z) this.f5306a.mo734b()).m8328y();
    }
}

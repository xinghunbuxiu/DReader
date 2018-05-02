package com.duokan.reader.domain.micloud;

import cn.kuaipan.android.http.IKscTransferListener;

/* renamed from: com.duokan.reader.domain.micloud.w */
class C1081w implements IKscTransferListener {
    /* renamed from: a */
    final /* synthetic */ C1079u f5304a;
    /* renamed from: b */
    private long f5305b;

    private C1081w(C1079u c1079u) {
        this.f5304a = c1079u;
        this.f5305b = 0;
    }

    public void setSendTotal(long j) {
    }

    public void setReceiveTotal(long j) {
    }

    public void setSendPos(long j) {
    }

    public void sended(long j) {
    }

    public void setReceivePos(long j) {
        this.f5305b = j;
        ((C1084z) this.f5304a.mo734b()).m8324b(this.f5305b, 0);
        this.f5304a.m8303m();
    }

    public void received(long j) {
        this.f5305b += j;
        ((C1084z) this.f5304a.mo734b()).m8324b(this.f5305b, j);
        this.f5304a.m8303m();
    }
}

package com.duokan.reader.domain.micloud;

import cn.kuaipan.android.http.IKscTransferListener;

/* renamed from: com.duokan.reader.domain.micloud.f */
class C1065f implements IKscTransferListener {
    /* renamed from: a */
    final /* synthetic */ C1063d f5268a;
    /* renamed from: b */
    private long f5269b;

    private C1065f(C1063d c1063d) {
        this.f5268a = c1063d;
        this.f5269b = 0;
    }

    public void setSendTotal(long j) {
    }

    public void setReceiveTotal(long j) {
    }

    public void setSendPos(long j) {
        this.f5269b = j;
        ((C1068i) this.f5268a.mo734b()).m8225b(this.f5269b, 0);
        this.f5268a.m8183b(true);
    }

    public void setReceivePos(long j) {
    }

    public void sended(long j) {
        this.f5269b += j;
        ((C1068i) this.f5268a.mo734b()).m8225b(this.f5269b, j);
        this.f5268a.m8183b(this.f5269b == j);
    }

    public void received(long j) {
    }
}

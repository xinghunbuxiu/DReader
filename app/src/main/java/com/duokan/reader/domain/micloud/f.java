package com.duokan.reader.domain.micloud;

import cn.kuaipan.android.http.IKscTransferListener;

class f implements IKscTransferListener {
    final /* synthetic */ d a;
    private long b;

    private f(d dVar) {
        this.a = dVar;
        this.b = 0;
    }

    public void setSendTotal(long j) {
    }

    public void setReceiveTotal(long j) {
    }

    public void setSendPos(long j) {
        this.b = j;
        ((i) this.a.b()).b(this.b, 0);
        this.a.b(true);
    }

    public void setReceivePos(long j) {
    }

    public void sended(long j) {
        this.b += j;
        ((i) this.a.b()).b(this.b, j);
        this.a.b(this.b == j);
    }

    public void received(long j) {
    }
}

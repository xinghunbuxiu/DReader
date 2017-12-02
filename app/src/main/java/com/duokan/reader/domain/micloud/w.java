package com.duokan.reader.domain.micloud;

import cn.kuaipan.android.http.IKscTransferListener;

class w implements IKscTransferListener {
    final /* synthetic */ u a;
    private long b;

    private w(u uVar) {
        this.a = uVar;
        this.b = 0;
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
        this.b = j;
        ((z) this.a.b()).b(this.b, 0);
        this.a.m();
    }

    public void received(long j) {
        this.b += j;
        ((z) this.a.b()).b(this.b, j);
        this.a.m();
    }
}

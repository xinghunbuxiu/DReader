package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.domain.account.UserAccount;

/* renamed from: com.duokan.reader.domain.downloadcenter.t */
class C1032t implements Runnable {
    /* renamed from: a */
    final /* synthetic */ UserAccount f5110a;
    /* renamed from: b */
    final /* synthetic */ C1030r f5111b;

    C1032t(C1030r c1030r, UserAccount userAccount) {
        this.f5111b = c1030r;
        this.f5110a = userAccount;
    }

    public void run() {
        this.f5111b.m7949a(this.f5110a);
    }
}

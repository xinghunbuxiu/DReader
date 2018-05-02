package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.domain.account.UserAccount;

/* renamed from: com.duokan.reader.domain.downloadcenter.s */
class C1031s implements Runnable {
    /* renamed from: a */
    final /* synthetic */ UserAccount f5108a;
    /* renamed from: b */
    final /* synthetic */ C1030r f5109b;

    C1031s(C1030r c1030r, UserAccount userAccount) {
        this.f5109b = c1030r;
        this.f5108a = userAccount;
    }

    public void run() {
        this.f5109b.m7949a(this.f5108a);
    }
}

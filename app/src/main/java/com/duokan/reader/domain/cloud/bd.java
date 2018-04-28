package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;

class bd implements C0586j {
    /* renamed from: a */
    final /* synthetic */ DkUserPurchasedBooksManager f3743a;

    bd(DkUserPurchasedBooksManager dkUserPurchasedBooksManager) {
        this.f3743a = dkUserPurchasedBooksManager;
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
        this.f3743a.f3608h = new ch();
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        this.f3743a.m5060a(false, false);
    }

    public void onAccountLogoff(C0672a c0672a) {
        ch chVar = new ch();
        chVar.f3812a = true;
        chVar.f3813b = true;
        this.f3743a.f3608h = chVar;
        this.f3743a.m5048f();
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }
}

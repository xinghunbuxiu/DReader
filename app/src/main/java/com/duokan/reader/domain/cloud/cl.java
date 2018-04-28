package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0519c;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;

class cl implements C0586j {
    /* renamed from: a */
    final /* synthetic */ DkUserPurchasedFictionsManager f3817a;

    cl(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager) {
        this.f3817a = dkUserPurchasedFictionsManager;
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
        this.f3817a.f3616h = new dr();
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        this.f3817a.m5100a(false, false, C0519c.f1752a);
    }

    public void onAccountLogoff(C0672a c0672a) {
        dr drVar = new dr();
        drVar.f3888a = true;
        drVar.f3889b = true;
        this.f3817a.f3616h = drVar;
        this.f3817a.m5091f();
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }
}

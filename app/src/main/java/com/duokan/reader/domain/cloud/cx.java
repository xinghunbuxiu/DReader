package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.c;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.h;

class cx implements h {
    final /* synthetic */ DkUserPurchasedFictionsManager a;

    cx(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager) {
        this.a = dkUserPurchasedFictionsManager;
    }

    public void a(a aVar) {
        this.a.h = new eg();
    }

    public void b(a aVar) {
        this.a.a(false, false, c.a);
    }

    public void c(a aVar) {
        eg egVar = new eg();
        egVar.a = true;
        egVar.b = true;
        this.a.h = egVar;
        this.a.f();
    }

    public void d(a aVar) {
    }
}

package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;

class dt implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ DkUserPurchasedFictionsManager b;

    dt(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, a aVar) {
        this.b = dkUserPurchasedFictionsManager;
        this.a = aVar;
    }

    public void run() {
        this.a.a(-1, "");
    }
}

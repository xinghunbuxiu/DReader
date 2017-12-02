package com.duokan.reader.domain.cloud;

class di implements Runnable {
    final /* synthetic */ DkUserPurchasedFictionsManager a;

    di(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager) {
        this.a = dkUserPurchasedFictionsManager;
    }

    public void run() {
        this.a.c.a(this.a.d);
    }
}

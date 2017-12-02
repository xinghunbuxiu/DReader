package com.duokan.reader.domain.cloud;

class do implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ DkUserPurchasedFictionsManager b;

    do(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, a aVar) {
        this.b = dkUserPurchasedFictionsManager;
        this.a = aVar;
    }

    public void run() {
        this.a.a(-1, "");
    }
}

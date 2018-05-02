package com.duokan.reader.domain.cloud;

class bv implements Runnable {
    final /* synthetic */ DkUserPurchasedBooksManager a;

    bv(DkUserPurchasedBooksManager dkUserPurchasedBooksManager) {
        this.a = dkUserPurchasedBooksManager;
    }

    public void run() {
        this.a.c.add(this.a.d);
    }
}

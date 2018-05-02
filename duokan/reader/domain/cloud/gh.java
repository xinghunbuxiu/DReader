package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;

class gh implements Runnable {
    final /* synthetic */ gf a;

    gh(gf gfVar) {
        this.a = gfVar;
    }

    public void run() {
        this.a.b.add(this.a.c);
        DkSharedStorageManager.a().a(this.a, SharedKey.CART_CACHE);
    }
}

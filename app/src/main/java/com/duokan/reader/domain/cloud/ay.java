package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;

class ay implements Runnable {
    final /* synthetic */ aw a;

    ay(aw awVar) {
        this.a = awVar;
    }

    public void run() {
        this.a.c.a(this.a.d);
        DkSharedStorageManager.a().a(this.a, SharedKey.USER_FAV_COUNT);
    }
}

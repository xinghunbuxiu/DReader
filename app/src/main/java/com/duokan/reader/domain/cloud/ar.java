package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;

class ar implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ap f3703a;

    ar(ap apVar) {
        this.f3703a = apVar;
    }

    public void run() {
        this.f3703a.f3697c.m3494a(this.f3703a.f3698d);
        DkSharedStorageManager.m5016a().m5025a(this.f3703a, SharedKey.USER_FAV_COUNT);
    }
}

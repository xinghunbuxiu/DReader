package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;

class aw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ av f3720a;

    aw(av avVar) {
        this.f3720a = avVar;
    }

    public void run() {
        this.f3720a.f3715c.m3494a(this.f3720a);
        DkSharedStorageManager.m5016a().m5025a(this.f3720a, SharedKey.USER_PRIVILEGE);
        this.f3720a.m5325a(true);
    }
}

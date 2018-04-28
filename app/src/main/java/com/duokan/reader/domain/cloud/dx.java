package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;

class dx implements Runnable {
    /* renamed from: a */
    final /* synthetic */ DkUserReadBookManager f3894a;

    dx(DkUserReadBookManager dkUserReadBookManager) {
        this.f3894a = dkUserReadBookManager;
    }

    public void run() {
        this.f3894a.f3619c.m3494a(this.f3894a.f3620d);
        DkSharedStorageManager.m5016a().m5025a(this.f3894a, SharedKey.USER_READ_COUNT);
    }
}

package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;

class em implements Runnable {
    final /* synthetic */ DkUserReadBookManager a;

    em(DkUserReadBookManager dkUserReadBookManager) {
        this.a = dkUserReadBookManager;
    }

    public void run() {
        this.a.c.a(this.a.d);
        DkSharedStorageManager.a().a(this.a, SharedKey.USER_READ_COUNT);
    }
}

package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;

import java.util.List;

class au implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ SharedKey b;
    final /* synthetic */ DkSharedStorageManager c;

    au(DkSharedStorageManager dkSharedStorageManager, List list, SharedKey sharedKey) {
        this.c = dkSharedStorageManager;
        this.a = list;
        this.b = sharedKey;
    }

    public void run() {
        for (av a : this.a) {
            a.a(this.b);
        }
    }
}

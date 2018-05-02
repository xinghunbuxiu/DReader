package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;

import java.io.Serializable;
import java.util.List;

class at implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ SharedKey b;
    final /* synthetic */ Serializable c;
    final /* synthetic */ DkSharedStorageManager d;

    at(DkSharedStorageManager dkSharedStorageManager, List list, SharedKey sharedKey, Serializable serializable) {
        this.d = dkSharedStorageManager;
        this.a = list;
        this.b = sharedKey;
        this.c = serializable;
    }

    public void run() {
        for (av a : this.a) {
            a.a(this.b, this.c);
        }
    }
}

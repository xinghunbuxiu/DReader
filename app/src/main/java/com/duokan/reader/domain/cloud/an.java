package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;
import java.util.List;

class an implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f3692a;
    /* renamed from: b */
    final /* synthetic */ SharedKey f3693b;
    /* renamed from: c */
    final /* synthetic */ DkSharedStorageManager f3694c;

    an(DkSharedStorageManager dkSharedStorageManager, List list, SharedKey sharedKey) {
        this.f3694c = dkSharedStorageManager;
        this.f3692a = list;
        this.f3693b = sharedKey;
    }

    public void run() {
        for (ao a : this.f3692a) {
            a.mo1153a(this.f3693b);
        }
    }
}

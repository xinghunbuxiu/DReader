package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;
import java.io.Serializable;
import java.util.List;

class am implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f3688a;
    /* renamed from: b */
    final /* synthetic */ SharedKey f3689b;
    /* renamed from: c */
    final /* synthetic */ Serializable f3690c;
    /* renamed from: d */
    final /* synthetic */ DkSharedStorageManager f3691d;

    am(DkSharedStorageManager dkSharedStorageManager, List list, SharedKey sharedKey, Serializable serializable) {
        this.f3691d = dkSharedStorageManager;
        this.f3688a = list;
        this.f3689b = sharedKey;
        this.f3690c = serializable;
    }

    public void run() {
        for (ao a : this.f3688a) {
            a.mo1154a(this.f3689b, this.f3690c);
        }
    }
}

package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;

class fn implements Runnable {
    /* renamed from: a */
    final /* synthetic */ fl f4009a;

    fn(fl flVar) {
        this.f4009a = flVar;
    }

    public void run() {
        this.f4009a.f4003b.m3494a(this.f4009a.f4004c);
        DkSharedStorageManager.m5016a().m5025a(this.f4009a, SharedKey.CART_CACHE);
    }
}

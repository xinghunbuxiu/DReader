package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;

class be implements Runnable {
    final /* synthetic */ bd a;

    be(bd bdVar) {
        this.a = bdVar;
    }

    public void run() {
        this.a.c.a(this.a);
        DkSharedStorageManager.a().a(this.a, SharedKey.USER_PRIVILEGE);
        this.a.a(true);
    }
}

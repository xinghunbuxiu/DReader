package com.duokan.core.ui;

import com.duokan.core.sys.UIdleHandler;

class ed implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ec f1214a;

    ed(ec ecVar) {
        this.f1214a = ecVar;
    }

    public void run() {
        if (this.f1214a.f1212a.requestFocus()) {
            UIdleHandler.addIdleHandler(new ee(this));
        }
    }
}

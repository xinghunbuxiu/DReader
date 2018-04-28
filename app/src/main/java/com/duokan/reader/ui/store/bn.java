package com.duokan.reader.ui.store;

import com.duokan.core.sys.UThread;

class bn implements Runnable {
    /* renamed from: a */
    final /* synthetic */ bl f11377a;

    bn(bl blVar) {
        this.f11377a = blVar;
    }

    public void run() {
        UThread.addIdleHandlerListener(new bo(this));
    }
}

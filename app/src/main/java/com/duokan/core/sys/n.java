package com.duokan.core.sys;

import android.os.MessageQueue.IdleHandler;

class n implements IdleHandler {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public boolean queueIdle() {
        return this.a.a.idleRun();
    }
}

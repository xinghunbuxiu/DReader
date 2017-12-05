package com.duokan.core.sys;

import android.os.MessageQueue.IdleHandler;

class MyIdleHandler implements IdleHandler {
    final AddIdleHandler idleHandler;

    MyIdleHandler(AddIdleHandler idleHandler) {
        this.idleHandler = idleHandler;
    }

    public boolean queueIdle() {
        return idleHandler.idleStatus.idleRun();
    }
}

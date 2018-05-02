package com.duokan.core.sys;

import android.os.Looper;

final class AddIdleHandler implements Runnable {
    final IdleStatus idleStatus;

    AddIdleHandler(IdleStatus idleStatus) {
        this.idleStatus = idleStatus;
    }

    public void run() {
        Looper.myQueue().addIdleHandler(new MyIdleHandler(this));
    }
}

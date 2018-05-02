package com.duokan.core.sys;

final class MyIdleStatus implements IdleStatus {
    final Runnable idleRun;

    MyIdleStatus(Runnable idleRun) {
        this.idleRun = idleRun;
    }

    public boolean idleRun() {
        this.idleRun.run();
        return false;
    }
}

package com.duokan.core.sys;

final class addIdleStatus implements Runnable {
    final IdleStatus idleStatus;

    addIdleStatus(IdleStatus idleStatus) {
        this.idleStatus = idleStatus;
    }

    public void run() {
        AIdleOperation.addIdleStatus(this.idleStatus);
    }
}

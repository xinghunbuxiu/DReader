package com.duokan.core.sys;

final class IdleRun implements Runnable {
    final IdleStatus idleStatus;
    final int mills;
    private boolean isIdleRun = false;

    IdleRun(IdleStatus sVar, int i) {
        this.idleStatus = sVar;
        this.mills = i;
    }

    public void run() {
        if (!this.isIdleRun) {
            this.isIdleRun = true;
            if (this.idleStatus.idleRun()) {
                AIdleOperation.ShowOrHide(this.idleStatus, this.mills);
            }
        }
    }
}

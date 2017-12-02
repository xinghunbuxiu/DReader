package com.duokan.core.sys;

final class l implements s {
    final /* synthetic */ Runnable a;

    l(Runnable runnable) {
        this.a = runnable;
    }

    public boolean idleRun() {
        this.a.run();
        return false;
    }
}

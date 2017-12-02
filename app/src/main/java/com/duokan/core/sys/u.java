package com.duokan.core.sys;

import java.util.concurrent.Callable;

final class u implements Callable {
    final /* synthetic */ Runnable a;

    u(Runnable runnable) {
        this.a = runnable;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Void a() {
        if (this.a != null) {
            this.a.run();
        }
        return null;
    }
}

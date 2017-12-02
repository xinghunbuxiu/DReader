package com.duokan.core.ui;

import java.util.concurrent.Callable;

final class eb implements Callable {
    final /* synthetic */ Runnable a;

    eb(Runnable runnable) {
        this.a = runnable;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        this.a.run();
        return Boolean.valueOf(false);
    }
}

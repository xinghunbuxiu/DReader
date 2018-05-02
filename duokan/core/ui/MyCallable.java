package com.duokan.core.ui;

import java.util.concurrent.Callable;

final class MyCallable implements Callable {
    final Runnable runnable;

    MyCallable(Runnable runnable) {
        this.runnable = runnable;
    }

    public Object call() {
        return a();
    }

    public Boolean a() {
        this.runnable.run();
        return false;
    }
}

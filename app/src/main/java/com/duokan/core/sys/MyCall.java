package com.duokan.core.sys;

import java.util.concurrent.Callable;

final class MyCall implements Callable {
    final Runnable runnable;

    MyCall(Runnable runnable) {
        this.runnable = runnable;
    }

    public Object call() {
        if (this.runnable != null) {
            this.runnable.run();
        }
        return null;
    }

}

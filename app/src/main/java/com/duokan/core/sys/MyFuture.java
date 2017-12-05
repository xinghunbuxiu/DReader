package com.duokan.core.sys;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class MyFuture<V> implements Future {

    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public V get() {
        return null;
    }

    public V get(long timeout, TimeUnit timeUnit) {
        return null;
    }
}

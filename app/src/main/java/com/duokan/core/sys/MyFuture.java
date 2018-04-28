package com.duokan.core.sys;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class MyFuture<T> implements Future {
    MyFuture() {
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public T get() {
        return null;
    }

    public T get(long timeout, TimeUnit timeUnit) {
        return null;
    }
}

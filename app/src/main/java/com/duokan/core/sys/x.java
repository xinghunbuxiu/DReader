package com.duokan.core.sys;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class x implements Future {
    x() {
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

    public Object get() {
        return null;
    }

    public Object get(long j, TimeUnit timeUnit) {
        return null;
    }
}

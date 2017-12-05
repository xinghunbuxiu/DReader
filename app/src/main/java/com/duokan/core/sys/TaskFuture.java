package com.duokan.core.sys;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class TaskFuture implements Future {
    final Object task;

    TaskFuture(Object obj) {
        this.task = obj;
    }

    public boolean cancel(boolean cancel) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public Object get() {
        return this.task;
    }

    public Object get(long j, TimeUnit timeUnit) {
        return this.task;
    }
}

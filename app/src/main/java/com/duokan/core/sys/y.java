package com.duokan.core.sys;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class y implements Future {
    final /* synthetic */ Object a;

    y(Object obj) {
        this.a = obj;
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
        return this.a;
    }

    public Object get(long j, TimeUnit timeUnit) {
        return this.a;
    }
}

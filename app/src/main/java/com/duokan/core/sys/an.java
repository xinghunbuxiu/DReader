package com.duokan.core.sys;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class an extends al implements ScheduledFuture {
    private final long b;

    public /* synthetic */ int compareTo(Object obj) {
        return a((Delayed) obj);
    }

    public an(String str, Runnable runnable, long j) {
        super(str, runnable);
        this.b = j;
    }

    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(Math.max(0, this.b - System.currentTimeMillis()), TimeUnit.MILLISECONDS);
    }

    public int a(Delayed delayed) {
        long delay = getDelay(TimeUnit.MILLISECONDS) - delayed.getDelay(TimeUnit.MILLISECONDS);
        if (delay == 0) {
            return 0;
        }
        return delay > 0 ? 1 : -1;
    }
}

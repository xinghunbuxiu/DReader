package com.duokan.core.sys;

import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class ao extends FutureTask implements ScheduledFuture {
    private final long a;

    public /* synthetic */ int compareTo(Object obj) {
        return a((Delayed) obj);
    }

    public ao(Runnable runnable, long j) {
        super(runnable, null);
        this.a = j;
    }

    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(Math.max(0, this.a - System.currentTimeMillis()), TimeUnit.MILLISECONDS);
    }

    public int a(Delayed delayed) {
        long delay = getDelay(TimeUnit.MILLISECONDS) - delayed.getDelay(TimeUnit.MILLISECONDS);
        if (delay == 0) {
            return 0;
        }
        return delay > 0 ? 1 : -1;
    }
}

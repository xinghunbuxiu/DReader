package com.duokan.core.sys;

import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class ao<T> extends FutureTask<T> implements ScheduledFuture<T> {
    /* renamed from: a */
    private final long f649a;

    public /* synthetic */ int compareTo(Object obj) {
        return m877a((Delayed) obj);
    }

    public ao(Runnable runnable, long j) {
        super(runnable, null);
        this.f649a = j;
    }

    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(Math.max(0, this.f649a - System.currentTimeMillis()), TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public int m877a(Delayed delayed) {
        long delay = getDelay(TimeUnit.MILLISECONDS) - delayed.getDelay(TimeUnit.MILLISECONDS);
        if (delay == 0) {
            return 0;
        }
        return delay > 0 ? 1 : -1;
    }
}

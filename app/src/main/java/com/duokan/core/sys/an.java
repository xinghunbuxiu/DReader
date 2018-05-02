package com.duokan.core.sys;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class an<T> extends al<T> implements ScheduledFuture<T> {
    /* renamed from: b */
    private final long f648b;

    public /* synthetic */ int compareTo(Object obj) {
        return m876a((Delayed) obj);
    }

    public an(String str, Runnable runnable, long j) {
        super(str, runnable);
        this.f648b = j;
    }

    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(Math.max(0, this.f648b - System.currentTimeMillis()), TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public int m876a(Delayed delayed) {
        long delay = getDelay(TimeUnit.MILLISECONDS) - delayed.getDelay(TimeUnit.MILLISECONDS);
        if (delay == 0) {
            return 0;
        }
        return delay > 0 ? 1 : -1;
    }
}

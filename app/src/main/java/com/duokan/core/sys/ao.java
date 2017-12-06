package com.duokan.core.sys;

import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class ao extends FutureTask implements ScheduledFuture {
    private final long time;


    public ao(Runnable runnable, long time) {
        super(runnable, null);
        this.time = time;
    }

    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(Math.max(0, this.time - System.currentTimeMillis()), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed delayed) {
        long delay = getDelay(TimeUnit.MILLISECONDS) - delayed.getDelay(TimeUnit.MILLISECONDS);
        if (delay == 0) {
            return 0;
        }
        return delay > 0 ? 1 : -1;
    }
}

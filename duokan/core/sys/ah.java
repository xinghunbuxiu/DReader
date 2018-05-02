package com.duokan.core.sys;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class ah {
    private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    private static final LinkedList<al> list = new LinkedList();

    public static Future future(Runnable runnable) {
        return future(runnable, "");
    }

    public static Future future(Runnable runnable, final String tag) {
        final Future future = new al(tag, runnable);
        executor.submit(new Runnable() {
            @Override
            public void run() {
                list.add((al) future);
                b(tag);
            }
        });
        return future;
    }

    public static ScheduledFuture scheduledFuture(final Runnable runnable, final String tag, long time) {
        final ScheduledFuture future = new an(tag, runnable, System.currentTimeMillis() + time);
        executor.schedule(new Runnable() {
            @Override
            public void run() {
                list.add((al) future);
                b(tag);
            }
        }, time, TimeUnit.MICROSECONDS);
        return future;
    }

    public static Future submitFuture(Runnable runnable) {
        return executorService.submit(runnable);
    }

    public static ScheduledFuture submitScheduledFuture(Runnable runnable, long j) {
        final ScheduledFuture aoVar = new ao(runnable, System.currentTimeMillis() + j);
        executor.schedule(new Runnable() {
            @Override
            public void run() {
                executorService.submit((Runnable) aoVar);
            }
        }, j, TimeUnit.MICROSECONDS);
        return aoVar;
    }

    private static void b(String str) {
        Iterator<al> it = list.iterator();
        while (it.hasNext()) {
            al alVar = it.next();
            if (alVar.tag.equals(str)) {
                if (!alVar.b) {
                    alVar.b = true;
                    executorService.submit(alVar);
                    return;
                }
                return;
            }
        }
    }

    static class al extends FutureTask {
        public final String tag;
        private boolean b = false;

        public al(String tag, Runnable runnable) {
            super(runnable, null);
            this.tag = tag;
        }

        public void run() {
            try {
                super.run();
            } finally {
                ah.executor.submit(new am(this));
            }
        }
    }

    static class am implements Runnable {
        final al a;

        am(al alVar) {
            this.a = alVar;
        }

        public void run() {
            list.remove(this.a);
            this.a.b = false;
            b(this.a.tag);
        }
    }

    static  class an extends al implements ScheduledFuture {
        private final long time;

        public an(String tag, Runnable runnable, long time) {
            super(tag, runnable);
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

}

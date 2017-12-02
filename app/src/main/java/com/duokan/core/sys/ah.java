package com.duokan.core.sys;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class ah {
    private static final ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor();
    private static final ExecutorService b = Executors.newCachedThreadPool();
    private static final LinkedList c = new LinkedList();

    public static Future a(Runnable runnable) {
        return a(runnable, "");
    }

    public static Future a(Runnable runnable, String str) {
        Future alVar = new al(str, runnable);
        a.submit(new ai(alVar, str));
        return alVar;
    }

    public static ScheduledFuture a(Runnable runnable, String str, long j) {
        ScheduledFuture anVar = new an(str, runnable, System.currentTimeMillis() + j);
        a.schedule(new aj(anVar, str), j, TimeUnit.MICROSECONDS);
        return anVar;
    }

    public static Future b(Runnable runnable) {
        return b.submit(runnable);
    }

    public static ScheduledFuture a(Runnable runnable, long j) {
        ScheduledFuture aoVar = new ao(runnable, System.currentTimeMillis() + j);
        a.schedule(new ak(aoVar), j, TimeUnit.MICROSECONDS);
        return aoVar;
    }

    private static void b(String str) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            al alVar = (al) it.next();
            if (alVar.a.equals(str)) {
                if (!alVar.b) {
                    alVar.b = true;
                    b.submit(alVar);
                    return;
                }
                return;
            }
        }
    }
}

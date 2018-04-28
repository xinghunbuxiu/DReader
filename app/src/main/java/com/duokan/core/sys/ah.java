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
    /* renamed from: a */
    private static final ScheduledExecutorService f637a = Executors.newSingleThreadScheduledExecutor();
    /* renamed from: b */
    private static final ExecutorService f638b = Executors.newCachedThreadPool();
    /* renamed from: c */
    private static final LinkedList<al<?>> f639c = new LinkedList();

    /* renamed from: a */
    public static Future<?> m865a(Runnable runnable) {
        return m866a(runnable, "");
    }

    /* renamed from: a */
    public static Future<?> m866a(Runnable runnable, String str) {
        Future alVar = new al(str, runnable);
        f637a.submit(new ai(alVar, str));
        return alVar;
    }

    /* renamed from: a */
    public static ScheduledFuture<?> m868a(Runnable runnable, String str, long j) {
        ScheduledFuture anVar = new an(str, runnable, System.currentTimeMillis() + j);
        f637a.schedule(new aj(anVar, str), j, TimeUnit.MICROSECONDS);
        return anVar;
    }

    /* renamed from: b */
    public static Future<?> m871b(Runnable runnable) {
        return f638b.submit(runnable);
    }

    /* renamed from: a */
    public static ScheduledFuture<?> m867a(Runnable runnable, long j) {
        ScheduledFuture aoVar = new ao(runnable, System.currentTimeMillis() + j);
        f637a.schedule(new ak(aoVar), j, TimeUnit.MICROSECONDS);
        return aoVar;
    }

    /* renamed from: b */
    private static void m872b(String str) {
        Iterator it = f639c.iterator();
        while (it.hasNext()) {
            al alVar = (al) it.next();
            if (alVar.f645a.equals(str)) {
                if (!alVar.f646b) {
                    alVar.f646b = true;
                    f638b.submit(alVar);
                    return;
                }
                return;
            }
        }
    }
}

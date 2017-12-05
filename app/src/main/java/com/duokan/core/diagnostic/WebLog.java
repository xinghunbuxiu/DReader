package com.duokan.core.diagnostic;

import com.duokan.core.sys.TaskHandler;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class WebLog extends HttpLogger {
    private static final Object a = new Object();
    private static WebLog webLog = null;
    private final AtomicReference atomicReference = new AtomicReference();
    private final UncaughtExceptionHandler exceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    private final HashMap e = new HashMap();
    private boolean f = false;
    private c g = null;

    public WebLog() {
        Thread.setDefaultUncaughtExceptionHandler(new b(this));
    }

    public void a(boolean z) {
        b(!z);
    }

    public void b(boolean z) {
        if (!z) {
            printStackTraceString(LogLevel.WARNING, "assert", "assertion error!");
        }
    }

    public void a() {
        b(TaskHandler.isCurrentThread());
    }

    public void b() {
        a(true);
    }

    public long a(String str) {
        long max;
        synchronized (this.e) {
            Long l = (Long) this.e.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            max = l == null ? 0 : Math.max(0, currentTimeMillis - l.longValue());
            this.e.put(str, Long.valueOf(currentTimeMillis));
        }
        return max;
    }

    public void a(c cVar) {
        this.g = cVar;
    }

    public static WebLog c() {
        if (webLog != null) {
            return webLog;
        }
        synchronized (a) {
            if (webLog != null) {
                WebLog aVar = webLog;
                return aVar;
            }
            webLog = new WebLog();
            return webLog;
        }
    }

    public void c(boolean z) {
        this.f = z;
    }

    public void d(boolean z) {
        d dVar;
        if (z) {
            d dVar2 = new d();
            dVar = (d) this.atomicReference.getAndSet(dVar2);
            dVar2.start();
        } else {
            dVar = (d) this.atomicReference.getAndSet(null);
        }
        if (dVar != null) {
            dVar.isStop = true;
        }
    }
}

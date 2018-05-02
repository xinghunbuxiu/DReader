package com.duokan.core.diagnostic;

import com.duokan.core.sys.UThread;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;


public class WebLog extends HttpLogger {

    private static final Object f556a = new Object();

    private static WebLog webLog = null;

    private final AtomicReference<C0331d> atomicReference = new AtomicReference();

    private final UncaughtExceptionHandler exceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

    private final HashMap<String, Long> map = new HashMap();

    private boolean isDebug = false;

    public IOnAnr onAnr = null;


    public WebLog() {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (isDebug) {
                    printStackTrace(LogLevel.DISASTER, "crash", "crash detected!", e);
                }
                if (exceptionHandler != null) {
                    exceptionHandler.uncaughtException(t, e);
                }
            }
        });
    }


    public void m762a(boolean z) {
        w(!z);
    }


    public void w(boolean z) {
        if (!z) {
            printStackTraceString(LogLevel.WARNING, "assert", "assertion error!");

        }
    }


    public void w() {
        w(UThread.isCurrentThread());
    }


    public void defaultW() {
        m762a(true);
    }


    public long getAppBginitTimer(String str) {
        long max;
        synchronized (this.map) {
            Long l = this.map.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            max = l == null ? 0 : Math.max(0, currentTimeMillis - l.longValue());
            this.map.put(str, Long.valueOf(currentTimeMillis));
        }
        return max;
    }


    public void setOnAnrListener(IOnAnr onAnr) {
        this.onAnr = onAnr;
    }


    public static WebLog init() {
        if (webLog != null) {
            return webLog;
        }
        synchronized (f556a) {
            if (webLog != null) {
                return webLog;
            }
            webLog = new WebLog();
            return webLog;
        }
    }


    public void setDebug(boolean z) {
        this.isDebug = z;
    }


    public void m766d(boolean z) {
        C0331d c0331d;
        if (z) {
            C0331d c0331d2 = new C0331d();
            c0331d =this.atomicReference.getAndSet(c0331d2);
            c0331d2.start();
        } else {
            c0331d = (C0331d) this.atomicReference.getAndSet(null);
        }
        if (c0331d != null) {
            c0331d.f564a = true;
        }
    }
}

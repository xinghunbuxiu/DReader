package com.duokan.core.diagnostic;

import com.duokan.core.sys.t;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class a extends f {
    private static final Object a = new Object();
    private static a b = null;
    private final AtomicReference c = new AtomicReference();
    private final UncaughtExceptionHandler d = Thread.getDefaultUncaughtExceptionHandler();
    private final HashMap e = new HashMap();
    private boolean f = false;
    private c g = null;

    public a() {
        Thread.setDefaultUncaughtExceptionHandler(new b(this));
    }

    public void a(boolean z) {
        b(!z);
    }

    public void b(boolean z) {
        if (!z) {
            try {
                throw new AssertionError();
            } catch (Throwable th) {
                a(LogLevel.WARNING, "assert", "assertion error!");
            }
        }
    }

    public void a() {
        b(t.a());
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

    public static a c() {
        if (b != null) {
            return b;
        }
        synchronized (a) {
            if (b != null) {
                a aVar = b;
                return aVar;
            }
            b = new a();
            return b;
        }
    }

    public void c(boolean z) {
        this.f = z;
    }

    public void d(boolean z) {
        d dVar;
        if (z) {
            d dVar2 = new d();
            dVar = (d) this.c.getAndSet(dVar2);
            dVar2.start();
        } else {
            dVar = (d) this.c.getAndSet(null);
        }
        if (dVar != null) {
            dVar.a = true;
        }
    }
}

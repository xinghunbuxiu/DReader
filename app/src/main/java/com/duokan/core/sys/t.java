package com.duokan.core.sys;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public abstract class t {
    public static final Handler a = new Handler(Looper.getMainLooper());

    public static final boolean a() {
        return Thread.currentThread() == b();
    }

    public static final Thread b() {
        return Looper.getMainLooper().getThread();
    }

    public static final void a(Runnable runnable) {
        b(new u(runnable));
    }

    public static final void b(Runnable runnable) {
        if (runnable != null) {
            a.post(runnable);
        }
    }

    public static final void a(Runnable runnable, long j) {
        if (runnable != null) {
            a.postDelayed(runnable, j);
        }
    }

    public static final void b(Runnable runnable, long j) {
        if (runnable != null) {
            a.postAtTime(runnable, j);
        }
    }

    public static final void a(s sVar, int i) {
        a.post(new v(sVar, i));
    }

    public static final void a(s sVar) {
        a.post(new w(sVar));
    }

    public static final Object a(Callable callable) {
        Future b = b(callable);
        while (true) {
            try {
                return b.get();
            } catch (InterruptedException e) {
            } catch (Throwable th) {
                return null;
            }
        }
    }

    public static final Future b(Callable callable) {
        if (callable == null) {
            return new x();
        }
        if (a()) {
            Object obj = null;
            try {
                obj = callable.call();
            } catch (Throwable th) {
            }
            return new y(obj);
        }
        Future futureTask = new FutureTask(callable);
        a.post(futureTask);
        return futureTask;
    }

    public static final void c(Runnable runnable) {
        if (runnable != null) {
            a.removeCallbacks(runnable);
        }
    }
}

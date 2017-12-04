package com.duokan.core.sys;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public abstract class TaskHandler {
    public static final Handler mHandler = new Handler(Looper.getMainLooper());

    public static final boolean isCurrentThread() {
        return Thread.currentThread() == getThead();
    }

    public static final Thread getThead() {
        return Looper.getMainLooper().getThread();
    }

    public static final void postTask(Runnable runnable) {
        PostTask(new u(runnable));
    }

    public static final void PostTask(Runnable runnable) {
        if (runnable != null) {
            mHandler.post(runnable);
        }
    }

    public static final void postDelayed(Runnable runnable, long j) {
        if (runnable != null) {
            mHandler.postDelayed(runnable, j);
        }
    }

    public static final void PostTask(Runnable runnable, long j) {
        if (runnable != null) {
            mHandler.postAtTime(runnable, j);
        }
    }

    public static final void postTask(s sVar, int i) {
        mHandler.post(new v(sVar, i));
    }

    public static final void postTask(s sVar) {
        mHandler.post(new w(sVar));
    }

    public static final <T> T postTask(Callable<T> callable) {
        Future<T> b = PostTask((Callable) callable);
        while (true) {
            try {
                return b.get();
            } catch (InterruptedException e) {
            } catch (Throwable th) {
                return null;
            }
        }
    }

    public static final <T> Future<T> PostTask(Callable<T> callable) {
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
        Future<T> futureTask = new FutureTask(callable);
        mHandler.post((Runnable) futureTask);
        return futureTask;
    }



    public static final void removeCallbacks(Runnable runnable) {
        if (runnable != null) {
            mHandler.removeCallbacks(runnable);
        }
    }
}

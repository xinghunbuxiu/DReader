package com.duokan.core.sys;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public abstract class TaskHandler {
    public static final Handler mHandler = new Handler(Looper.getMainLooper());

    public static final boolean isCurrentThread() {
        return Thread.currentThread() == getThread();
    }

    public static final Thread getThread() {
        return Looper.getMainLooper().getThread();
    }

    public static final void postTask(Runnable runnable) {
        PostTask(new MyCall(runnable));
    }

    public static final void PostTask(Runnable runnable) {
        if (runnable != null) {
            mHandler.post(runnable);
        }
    }

    public static final void postDelayed(Runnable runnable, long delayMillis) {
        if (runnable != null) {
            mHandler.postDelayed(runnable, delayMillis);
        }
    }

    public static final void PostTask(Runnable runnable, long uptimeMillis) {
        if (runnable != null) {
            mHandler.postAtTime(runnable, uptimeMillis);
        }
    }

    public static final void postTask(final IdleStatus idleStatus, final int delayMillis) {
        mHandler.post(new Runnable() {

            @Override
            public void run() {
                AIdleOperation.ShowOrHide(idleStatus, delayMillis);
            }
        });
    }

    public static final void requstIdleStatusListening(IdleStatus sVar) {
        mHandler.post(new addIdleStatus(sVar));
    }

    public static final <T> T getTaskHandler(Callable<T> callable) {
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
            return new MyFuture<T>();
        }
        if (isCurrentThread()) {
            T obj = null;
            try {
                obj = callable.call();
            } catch (Throwable th) {
            }
            return new TaskFuture(obj);
        }
        FutureTask futureTask = new FutureTask(callable);
        mHandler.post(futureTask);
        return futureTask;
    }


    public static final void removeCallbacks(Runnable runnable) {
        if (runnable != null) {
            mHandler.removeCallbacks(runnable);
        }
    }
}

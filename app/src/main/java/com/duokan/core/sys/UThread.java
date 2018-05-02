package com.duokan.core.sys;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class UThread {
    public static final Handler mHandler = new Handler(Looper.getMainLooper());

    public static final boolean isCurrentThread() {
        return Thread.currentThread() == getCurrentThread();
    }

    public static final Thread getCurrentThread() {
        return Looper.getMainLooper().getThread();
    }

    public static final void runOnThread(final Runnable runnable) {
        postFuture(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                if (runnable != null) {
                    runnable.run();
                }
                return null;
            }
        });
    }

    public static final void post(Runnable runnable) {
        if (runnable != null) {
            mHandler.post(runnable);
        }
    }

    public static final void postDelayed(Runnable runnable, long delayMillis) {
        if (runnable != null) {
            mHandler.postDelayed(runnable, delayMillis);
        }
    }

    public static final void postAtTime(Runnable runnable, long uptimeMillis) {
        if (runnable != null) {
            mHandler.postAtTime(runnable, uptimeMillis);
        }
    }

    public static final void addIdleHandlerDelayed(final IdleHandlerListener idleRunListening, final int delayMillis) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                UIdleHandler.addIdleHandlerDelayed(idleRunListening, delayMillis);
            }
        });
    }

    public static final void addIdleHandlerListener(final IdleHandlerListener idleRunListening) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                UIdleHandler.addIdleHandler(idleRunListening);
            }
        });
    }

    public static final <T> T m1035a(Callable<T> callable) {
        Future<T> b = postFuture(callable);
        while (true) {
            try {
                return b.get();
            } catch (InterruptedException e) {
            } catch (Throwable th) {
                return null;
            }
        }
    }

    public static final <T> Future<T> postFuture(Callable<T> callable) {
        if (callable == null) {
            return new MyFuture<T>();
        }

        if (isCurrentThread()) {
            T obj = null;
            try {
                obj = callable.call();
            } catch (Throwable th) {
            }
            final T finalObj = obj;
            return new Future<T>() {
                @Override
                public boolean cancel(boolean mayInterruptIfRunning) {
                    return false;
                }

                @Override
                public boolean isCancelled() {
                    return false;
                }

                @Override
                public boolean isDone() {
                    return true;
                }

                @Override
                public T get() throws InterruptedException, ExecutionException {
                    return finalObj;
                }

                @Override
                public T get(long timeout, @NonNull TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                    return finalObj;
                }
            };
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

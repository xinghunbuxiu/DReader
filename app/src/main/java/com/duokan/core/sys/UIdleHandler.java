package com.duokan.core.sys;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;

public abstract class UIdleHandler {
    public static final Thread getCurrentThread() {
        return Thread.currentThread();
    }

    static final class IdleRunnable implements Runnable {

        final IdleHandlerListener idleRunListening;
        final int delayMillis;
        private boolean isRun = false;

        IdleRunnable(IdleHandlerListener idleRunListening, int delayMillis) {
            this.idleRunListening = idleRunListening;
            this.delayMillis = delayMillis;
        }

        public void run() {
            if (!this.isRun) {
                this.isRun = true;
                if (this.idleRunListening.idleRun()) {
                    addIdleHandlerDelayed(this.idleRunListening, this.delayMillis);
                }
            }
        }
    }

    public static final void addIdleHandlerDelayed(IdleHandlerListener idleRunListening, int delayMillis) {

        if (idleRunListening != null) {
            final Runnable run = new IdleRunnable(idleRunListening, delayMillis);
            addIdleHandler(new IdleHandlerListener() {
                @Override
                public boolean idleRun() {
                    run.run();
                    return false;
                }
            });
            new Handler().postDelayed(run, delayMillis);
        }
    }

    public static final void addIdleHandler(final IdleHandlerListener idleRunListening) {
        if (idleRunListening != null) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                        @Override
                        public boolean queueIdle() {
                            return idleRunListening.idleRun();
                        }
                    });
                }
            });
        }
    }

    public static final void runAction(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public static final void sleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
        }
    }
}

package com.duokan.core.sys;

import android.os.Handler;

public abstract class AIdleOperation {
    public static final Thread getCurrentThread() {
        return Thread.currentThread();
    }

    public static final void ShowOrHide(IdleStatus sVar, int mills) {
        if (sVar != null) {
            IdleRun idleRun = new IdleRun(sVar, mills);
            addIdleStatus(new MyIdleStatus(idleRun));
            new Handler().postDelayed(idleRun, mills);
        }
    }

    public static final void addIdleStatus(IdleStatus idleStatus) {
        if (idleStatus != null) {
            new Handler().post(new AddIdleHandler(idleStatus));
        }
    }

    public static final void postRunnable(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public static final void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
        }
    }
}

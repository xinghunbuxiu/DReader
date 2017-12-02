package com.duokan.core.sys;

import android.os.Handler;

public abstract class j {
    public static final Thread a() {
        return Thread.currentThread();
    }

    public static final void a(s sVar, int i) {
        if (sVar != null) {
            Runnable kVar = new k(sVar, i);
            a(new l(kVar));
            new Handler().postDelayed(kVar, (long) i);
        }
    }

    public static final void a(s sVar) {
        if (sVar != null) {
            new Handler().post(new m(sVar));
        }
    }

    public static final void a(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public static final void a(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
        }
    }
}

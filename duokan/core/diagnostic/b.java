package com.duokan.core.diagnostic;

import java.lang.Thread.UncaughtExceptionHandler;

class b implements UncaughtExceptionHandler {
    final /* synthetic */ WebLog a;

    b(WebLog aVar) {
        this.a = aVar;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (this.a.f) {
            this.a.printStackTrace(LogLevel.DISASTER, "crash", "crash detected!", th);
        }
        if (this.a.d != null) {
            this.a.d.uncaughtException(thread, th);
        }
    }
}

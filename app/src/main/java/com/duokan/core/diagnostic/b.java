package com.duokan.core.diagnostic;

import java.lang.Thread.UncaughtExceptionHandler;

class b implements UncaughtExceptionHandler {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (this.a.f) {
            this.a.a(LogLevel.DISASTER, "crash", "crash detected!", th);
        }
        if (this.a.d != null) {
            this.a.d.uncaughtException(thread, th);
        }
    }
}

package com.duokan.reader.common.p037c;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;

/* renamed from: com.duokan.reader.common.c.g */
class C0560g implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0559f f1848a;

    C0560g(C0559f c0559f) {
        this.f1848a = c0559f;
    }

    public void run() {
        if (!this.f1848a.m2486e()) {
            WebLog.init().c(LogLevel.EVENT, "net", "network disconnected");
        } else if (this.f1848a.m2485d()) {
            WebLog.init().c(LogLevel.EVENT, "net", "network connected(wifi)");
        } else {
            WebLog.init().c(LogLevel.EVENT, "net", "network connected(mobile)");
        }
        this.f1848a.m2474a(this.f1848a.m2486e());
        this.f1848a.m2478g();
    }
}

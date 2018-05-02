package com.duokan.reader.domain.ad;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import java.util.Collection;
import java.util.List;

/* renamed from: com.duokan.reader.domain.ad.k */
class C0754k implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0753j f2567a;

    C0754k(C0753j c0753j) {
        this.f2567a = c0753j;
    }

    public void run() {
        if (this.f2567a.f2565a != null && this.f2567a.f2565a.b == 0) {
            if (this.f2567a.f2565a.f2058a == null || ((List) this.f2567a.f2565a.f2058a).size() == 0) {
                synchronized (this.f2567a.f2566b) {
                    C0750g.m3579n(this.f2567a.f2566b);
                }
                WebLog.init().c(LogLevel.WARNING, "ads", "Empty ads list");
                return;
            }
            this.f2567a.f2566b.f2561t.clear();
            this.f2567a.f2566b.f2561t.addAll((Collection) this.f2567a.f2565a.f2058a);
        }
    }
}

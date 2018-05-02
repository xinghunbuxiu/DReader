package com.duokan.reader.domain.ad;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import java.util.Collection;
import java.util.List;

/* renamed from: com.duokan.reader.domain.ad.m */
class C0756m implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0755l f2570a;

    C0756m(C0755l c0755l) {
        this.f2570a = c0755l;
    }

    public void run() {
        if (this.f2570a.f2568a != null && this.f2570a.f2568a.b == 0) {
            if (this.f2570a.f2568a.f2058a == null || ((List) this.f2570a.f2568a.f2058a).size() == 0) {
                synchronized (this.f2570a.f2569b) {
                    C0750g.m3579n(this.f2570a.f2569b);
                }
                WebLog.init().c(LogLevel.WARNING, "ads", "Empty ads list");
                return;
            }
            this.f2570a.f2569b.f2562u.clear();
            this.f2570a.f2569b.f2562u.addAll((Collection) this.f2570a.f2568a.f2058a);
        }
    }
}

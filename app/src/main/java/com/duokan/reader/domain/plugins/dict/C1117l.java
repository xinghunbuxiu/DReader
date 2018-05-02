package com.duokan.reader.domain.plugins.dict;

import com.duokan.core.sys.UThread;
import com.kingsoft.iciba.sdk2.KSCibaEngine;

/* renamed from: com.duokan.reader.domain.plugins.dict.l */
class C1117l implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f5411a;
    /* renamed from: b */
    final /* synthetic */ C1115j f5412b;

    C1117l(C1115j c1115j, Runnable runnable) {
        this.f5412b = c1115j;
        this.f5411a = runnable;
    }

    public void run() {
        try {
            if (this.f5412b.f5408d == null) {
                this.f5412b.f5408d = new KSCibaEngine(this.f5412b.f5409e);
            }
            this.f5412b.f5408d.installEngine(C1115j.f5405a, 65894897);
        } catch (Throwable th) {
        }
        UThread.runOnThread(this.f5411a);
    }
}

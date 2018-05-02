package com.duokan.reader.domain.plugins.dict;

import com.kingsoft.iciba.sdk2.KSCibaEngine;

/* renamed from: com.duokan.reader.domain.plugins.dict.k */
class C1116k implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1115j f5410a;

    C1116k(C1115j c1115j) {
        this.f5410a = c1115j;
    }

    public void run() {
        try {
            if (this.f5410a.f5408d == null) {
                this.f5410a.f5408d = new KSCibaEngine(this.f5410a.f5409e);
            }
            this.f5410a.f5408d.installEngine(C1115j.f5405a, 65894897);
        } catch (Throwable th) {
        }
    }
}

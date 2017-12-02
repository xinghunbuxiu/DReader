package com.duokan.reader.domain.ad;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;

import java.util.Collection;
import java.util.List;

class k implements Runnable {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public void run() {
        if (this.a.a != null && this.a.a.b == 0) {
            if (this.a.a.a == null || ((List) this.a.a.a).size() == 0) {
                synchronized (this.a.b) {
                    g.n(this.a.b);
                }
                a.c().c(LogLevel.WARNING, "ads", "Empty ads list");
                return;
            }
            this.a.b.t.clear();
            this.a.b.t.addAll((Collection) this.a.a.a);
        }
    }
}

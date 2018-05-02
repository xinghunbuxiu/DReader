package com.duokan.reader.domain.plugins.dict;

import com.kingsoft.iciba.sdk2.KSCibaEngine;

class k implements Runnable {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public void run() {
        try {
            if (this.a.d == null) {
                this.a.d = new KSCibaEngine(this.a.e);
            }
            this.a.d.installEngine(j.a, 65894897);
        } catch (Throwable th) {
        }
    }
}

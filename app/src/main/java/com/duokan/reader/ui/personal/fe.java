package com.duokan.reader.ui.personal;

import com.duokan.core.sys.UThread;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.be;

class fe implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ez f8537a;

    fe(ez ezVar) {
        this.f8537a = ezVar;
    }

    public void run() {
        be.m10286a(this.f8537a.f8530a.f8523a, C0258j.store__mi_live__update_failed, 0).show();
        UThread.runOnThread(new ff(this));
    }
}

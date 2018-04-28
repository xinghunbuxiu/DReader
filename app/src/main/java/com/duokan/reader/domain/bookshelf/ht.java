package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.UThread;

class ht implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f3325a;
    /* renamed from: b */
    final /* synthetic */ hc f3326b;

    ht(hc hcVar, Runnable runnable) {
        this.f3326b = hcVar;
        this.f3325a = runnable;
    }

    public void run() {
        UThread.runOnThread(this.f3325a);
    }
}

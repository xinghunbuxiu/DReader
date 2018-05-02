package com.duokan.reader.ui.surfing;

import com.duokan.core.sys.UThread;

class aj implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f11515a;
    /* renamed from: b */
    final /* synthetic */ C1522i f11516b;

    aj(C1522i c1522i, Runnable runnable) {
        this.f11516b = c1522i;
        this.f11515a = runnable;
    }

    public void run() {
        this.f11516b.f11544l.setVisibility(4);
        UThread.post(this.f11515a);
    }
}

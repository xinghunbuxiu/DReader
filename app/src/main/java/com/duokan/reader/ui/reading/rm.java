package com.duokan.reader.ui.reading;

import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.statistics.C1163a;

class rm implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f10902a;
    /* renamed from: b */
    final /* synthetic */ qr f10903b;

    rm(qr qrVar, Runnable runnable) {
        this.f10903b = qrVar;
        this.f10902a = runnable;
    }

    public void run() {
        if (this.f10903b.f9282f.ak()) {
            C1163a.m8627k().m8636a(this.f10903b.f9282f, this.f10903b.f9290n, (int) (Math.max(0, System.currentTimeMillis() - this.f10903b.f9289m) / 1000));
        }
        UThread.runOnThread(this.f10902a);
    }
}

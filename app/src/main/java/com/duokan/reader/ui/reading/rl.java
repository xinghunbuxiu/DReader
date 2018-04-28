package com.duokan.reader.ui.reading;

import com.duokan.core.sys.UThread;

class rl implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f10900a;
    /* renamed from: b */
    final /* synthetic */ qr f10901b;

    rl(qr qrVar, Runnable runnable) {
        this.f10901b = qrVar;
        this.f10900a = runnable;
    }

    public void run() {
        this.f10901b.m12791a(null);
        UThread.post(this.f10900a);
    }
}

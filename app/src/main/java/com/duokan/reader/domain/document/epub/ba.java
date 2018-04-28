package com.duokan.reader.domain.document.epub;

import com.duokan.core.sys.UThread;

class ba implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f4546a;
    /* renamed from: b */
    final /* synthetic */ Runnable f4547b;
    /* renamed from: c */
    final /* synthetic */ az f4548c;

    ba(az azVar, Runnable runnable, Runnable runnable2) {
        this.f4548c = azVar;
        this.f4546a = runnable;
        this.f4547b = runnable2;
    }

    public void run() {
        while (!this.f4548c.f4532m && !this.f4548c.f4529j.m6797d() && this.f4548c.f4524e.a && !this.f4548c.f4524e.mo1272c()) {
            try {
                Thread.sleep(50);
            } catch (Throwable th) {
            }
        }
        UThread.runOnThread(new bb(this));
    }
}

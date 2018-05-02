package com.duokan.reader.domain.document.epub;

import com.duokan.core.sys.UThread;
import java.util.concurrent.TimeUnit;

/* renamed from: com.duokan.reader.domain.document.epub.n */
class C0948n implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f4716a;
    /* renamed from: b */
    final /* synthetic */ Runnable f4717b;
    /* renamed from: c */
    final /* synthetic */ C0942i f4718c;

    C0948n(C0942i c0942i, Runnable runnable, Runnable runnable2) {
        this.f4718c = c0942i;
        this.f4716a = runnable;
        this.f4717b = runnable2;
    }

    public void run() {
        while (!this.f4718c.f4706r && !this.f4718c.f4698j.m6797d() && this.f4718c.f4692d.a && !this.f4718c.f4692d.mo1272c()) {
            try {
                this.f4718c.f4708t.await(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
            }
        }
        UThread.runOnThread(new C0949o(this));
    }
}

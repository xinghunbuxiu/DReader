package com.duokan.reader.domain.document.txt;

import com.duokan.core.sys.UThread;
import java.util.concurrent.TimeUnit;

/* renamed from: com.duokan.reader.domain.document.txt.k */
class C0996k implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f4972a;
    /* renamed from: b */
    final /* synthetic */ Runnable f4973b;
    /* renamed from: c */
    final /* synthetic */ C0990f f4974c;

    C0996k(C0990f c0990f, Runnable runnable, Runnable runnable2) {
        this.f4974c = c0990f;
        this.f4972a = runnable;
        this.f4973b = runnable2;
    }

    public void run() {
        while (!this.f4974c.f4965p && !this.f4974c.f4959j.m7500d() && this.f4974c.f4953d.a && !this.f4974c.f4953d.mo1272c()) {
            try {
                this.f4974c.f4966q.await(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
            }
        }
        UThread.runOnThread(new C0997l(this));
    }
}

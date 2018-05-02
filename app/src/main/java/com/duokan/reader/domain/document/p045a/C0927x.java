package com.duokan.reader.domain.document.p045a;

import com.duokan.core.sys.UThread;

/* renamed from: com.duokan.reader.domain.document.a.x */
class C0927x implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f4395a;
    /* renamed from: b */
    final /* synthetic */ Runnable f4396b;
    /* renamed from: c */
    final /* synthetic */ C0926w f4397c;

    C0927x(C0926w c0926w, Runnable runnable, Runnable runnable2) {
        this.f4397c = c0926w;
        this.f4395a = runnable;
        this.f4396b = runnable2;
    }

    public void run() {
        while (!this.f4397c.f4388j && !this.f4397c.f4387i.m5807c() && this.f4397c.f4382d.a && !this.f4397c.f4382d.mo1272c()) {
            try {
                Thread.sleep(50);
            } catch (Throwable th) {
            }
        }
        UThread.runOnThread(new C0928y(this));
    }
}

package com.duokan.reader.domain.document.txt;

import com.duokan.core.sys.UThread;

class ak implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f4903a;
    /* renamed from: b */
    final /* synthetic */ Runnable f4904b;
    /* renamed from: c */
    final /* synthetic */ aj f4905c;

    ak(aj ajVar, Runnable runnable, Runnable runnable2) {
        this.f4905c = ajVar;
        this.f4903a = runnable;
        this.f4904b = runnable2;
    }

    public void run() {
        while (!this.f4905c.f4895j && !this.f4905c.f4894i.m7500d() && this.f4905c.f4889d.a && !this.f4905c.f4889d.mo1272c()) {
            try {
                Thread.sleep(50);
            } catch (Throwable th) {
            }
        }
        UThread.runOnThread(new al(this));
    }
}

package com.duokan.reader.domain.document.sbk;

import com.duokan.core.sys.UThread;

/* renamed from: com.duokan.reader.domain.document.sbk.z */
class C0984z implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f4870a;
    /* renamed from: b */
    final /* synthetic */ Runnable f4871b;
    /* renamed from: c */
    final /* synthetic */ C0983y f4872c;

    C0984z(C0983y c0983y, Runnable runnable, Runnable runnable2) {
        this.f4872c = c0983y;
        this.f4870a = runnable;
        this.f4871b = runnable2;
    }

    public void run() {
        while (!this.f4872c.f4860j && !this.f4872c.f4859i.m7116c() && this.f4872c.f4854d.a && !this.f4872c.f4854d.mo1272c()) {
            try {
                Thread.sleep(50);
            } catch (Throwable th) {
            }
        }
        UThread.runOnThread(new aa(this));
    }
}

package com.duokan.reader.ui.reading;

import com.duokan.core.sys.UThread;

class lo implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f10575a;
    /* renamed from: b */
    final /* synthetic */ lm f10576b;

    lo(lm lmVar, Runnable runnable) {
        this.f10576b = lmVar;
        this.f10575a = runnable;
    }

    public void run() {
        UThread.post(this.f10575a);
    }
}

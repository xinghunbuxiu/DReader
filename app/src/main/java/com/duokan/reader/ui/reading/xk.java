package com.duokan.reader.ui.reading;

import com.duokan.core.sys.UThread;

class xk implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f11147a;
    /* renamed from: b */
    final /* synthetic */ xj f11148b;

    xk(xj xjVar, Runnable runnable) {
        this.f11148b = xjVar;
        this.f11147a = runnable;
    }

    public void run() {
        if (this.f11148b.m15066a()) {
            UThread.post(new xl(this));
        }
        this.f11148b.f11144b.addLast(this.f11147a);
    }
}

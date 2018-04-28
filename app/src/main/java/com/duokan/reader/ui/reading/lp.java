package com.duokan.reader.ui.reading;

class lp implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f10577a;
    /* renamed from: b */
    final /* synthetic */ ll f10578b;

    lp(ll llVar, Runnable runnable) {
        this.f10578b = llVar;
        this.f10577a = runnable;
    }

    public void run() {
        this.f10577a.run();
    }
}

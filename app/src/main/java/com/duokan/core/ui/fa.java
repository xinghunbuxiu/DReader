package com.duokan.core.ui;

class fa implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f1238a;
    /* renamed from: b */
    final /* synthetic */ ev f1239b;

    fa(ev evVar, Runnable runnable) {
        this.f1239b = evVar;
        this.f1238a = runnable;
    }

    public void run() {
        if (this.f1238a != null) {
            this.f1239b.f935a.post(this.f1238a);
        }
    }
}

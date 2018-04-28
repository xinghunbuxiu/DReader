package com.duokan.core.ui;

class fc implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f1242a;
    /* renamed from: b */
    final /* synthetic */ ev f1243b;

    fc(ev evVar, Runnable runnable) {
        this.f1243b = evVar;
        this.f1242a = runnable;
    }

    public void run() {
        if (this.f1242a != null) {
            this.f1243b.f935a.post(this.f1242a);
        }
    }
}

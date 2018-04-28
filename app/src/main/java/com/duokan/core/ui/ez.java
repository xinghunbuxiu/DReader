package com.duokan.core.ui;

import com.duokan.core.ui.Scrollable.ScrollState;

class ez implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f1236a;
    /* renamed from: b */
    final /* synthetic */ ev f1237b;

    ez(ev evVar, Runnable runnable) {
        this.f1237b = evVar;
        this.f1236a = runnable;
    }

    public void run() {
        this.f1237b.m1416a(ScrollState.IDLE);
        if (this.f1236a != null) {
            this.f1237b.f935a.post(this.f1236a);
        }
    }
}

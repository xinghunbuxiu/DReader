package com.duokan.core.ui;

import com.duokan.core.ui.Scrollable.ScrollState;

class fb implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f1240a;
    /* renamed from: b */
    final /* synthetic */ ev f1241b;

    fb(ev evVar, Runnable runnable) {
        this.f1241b = evVar;
        this.f1240a = runnable;
    }

    public void run() {
        this.f1241b.m1416a(ScrollState.IDLE);
        if (this.f1240a != null) {
            this.f1241b.f935a.post(this.f1240a);
        }
    }
}

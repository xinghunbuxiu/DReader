package com.duokan.core.ui;

import com.duokan.core.ui.Scrollable.ScrollState;

class ez implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ ev b;

    ez(ev evVar, Runnable runnable) {
        this.b = evVar;
        this.a = runnable;
    }

    public void run() {
        this.b.a(ScrollState.IDLE);
        if (this.a != null) {
            this.b.a.post(this.a);
        }
    }
}

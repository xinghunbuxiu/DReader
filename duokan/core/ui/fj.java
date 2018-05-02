package com.duokan.core.ui;

import com.duokan.core.ui.Scrollable.ScrollState;

class fj implements Runnable {
    final /* synthetic */ ff a;

    fj(ff ffVar) {
        this.a = ffVar;
    }

    public void run() {
        this.a.a.a(ScrollState.IDLE);
    }
}

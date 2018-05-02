package com.duokan.core.ui;

import com.duokan.core.ui.Scrollable.ScrollState;

class ex implements Runnable {
    final /* synthetic */ ev a;

    ex(ev evVar) {
        this.a = evVar;
    }

    public void run() {
        this.a.a(ScrollState.IDLE);
    }
}

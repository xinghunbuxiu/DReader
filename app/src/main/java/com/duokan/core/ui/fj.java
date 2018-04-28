package com.duokan.core.ui;

import com.duokan.core.ui.Scrollable.ScrollState;

class fj implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ff f1255a;

    fj(ff ffVar) {
        this.f1255a = ffVar;
    }

    public void run() {
        this.f1255a.f1249a.m1416a(ScrollState.IDLE);
    }
}

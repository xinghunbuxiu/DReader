package com.duokan.core.ui;

import com.duokan.core.sys.t;

class gd implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ ZoomView b;

    gd(ZoomView zoomView, Runnable runnable) {
        this.b = zoomView;
        this.a = runnable;
    }

    public void run() {
        this.b.l = null;
        t.b(this.a);
    }
}

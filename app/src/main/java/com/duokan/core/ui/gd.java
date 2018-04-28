package com.duokan.core.ui;

import com.duokan.core.sys.UThread;

class gd implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f1292a;
    /* renamed from: b */
    final /* synthetic */ ZoomView f1293b;

    gd(ZoomView zoomView, Runnable runnable) {
        this.f1293b = zoomView;
        this.f1292a = runnable;
    }

    public void run() {
        this.f1293b.f880l = null;
        UThread.post(this.f1292a);
    }
}

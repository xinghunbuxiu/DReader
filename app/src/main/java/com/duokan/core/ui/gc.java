package com.duokan.core.ui;

import com.duokan.core.sys.UThread;
import com.duokan.core.ui.ZoomView.ZoomState;

class gc implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f1290a;
    /* renamed from: b */
    final /* synthetic */ ZoomView f1291b;

    gc(ZoomView zoomView, Runnable runnable) {
        this.f1291b = zoomView;
        this.f1290a = runnable;
    }

    public void run() {
        this.f1291b.f880l = null;
        this.f1291b.m1332a(ZoomState.IDLE);
        UThread.post(this.f1290a);
    }
}

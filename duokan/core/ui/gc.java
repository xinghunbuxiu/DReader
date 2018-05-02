package com.duokan.core.ui;

import com.duokan.core.sys.TaskHandler;
import com.duokan.core.ui.ZoomView.ZoomState;

class gc implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ ZoomView b;

    gc(ZoomView zoomView, Runnable runnable) {
        this.b = zoomView;
        this.a = runnable;
    }

    public void run() {
        this.b.l = null;
        this.b.a(ZoomState.IDLE);
        TaskHandler.PostTask(this.a);
    }
}

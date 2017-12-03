package com.duokan.core.ui;

import com.duokan.core.sys.TaskHandler;

class fy implements Runnable {
    final /* synthetic */ fx a;

    fy(fx fxVar) {
        this.a = fxVar;
    }

    public void run() {
        TaskHandler.postTask(new fz(this));
    }
}

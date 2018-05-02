package com.duokan.reader.ui.reading;

import com.duokan.core.sys.TaskHandler;

class wx implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ ww b;

    wx(ww wwVar, Runnable runnable) {
        this.b = wwVar;
        this.a = runnable;
    }

    public void run() {
        if (this.b.a()) {
            TaskHandler.PostTask(new wy(this));
        }
        this.b.b.addLast(this.a);
    }
}

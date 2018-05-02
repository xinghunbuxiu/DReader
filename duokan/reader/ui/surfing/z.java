package com.duokan.reader.ui.surfing;

import com.duokan.core.sys.TaskHandler;

class z implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ f b;

    z(f fVar, Runnable runnable) {
        this.b = fVar;
        this.a = runnable;
    }

    public void run() {
        this.b.i.setVisibility(4);
        TaskHandler.PostTask(this.a);
    }
}

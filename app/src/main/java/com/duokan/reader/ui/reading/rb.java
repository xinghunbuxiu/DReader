package com.duokan.reader.ui.reading;

import com.duokan.core.sys.TaskHandler;

class rb implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ qh b;

    rb(qh qhVar, Runnable runnable) {
        this.b = qhVar;
        this.a = runnable;
    }

    public void run() {
        this.b.a(null);
        TaskHandler.PostTask(this.a);
    }
}

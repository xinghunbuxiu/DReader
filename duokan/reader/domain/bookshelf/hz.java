package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.TaskHandler;

class hz implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ hi b;

    hz(hi hiVar, Runnable runnable) {
        this.b = hiVar;
        this.a = runnable;
    }

    public void run() {
        TaskHandler.postTask(this.a);
    }
}

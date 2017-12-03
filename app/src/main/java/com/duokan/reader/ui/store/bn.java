package com.duokan.reader.ui.store;

import com.duokan.core.sys.TaskHandler;

class bn implements Runnable {
    final /* synthetic */ bl a;

    bn(bl blVar) {
        this.a = blVar;
    }

    public void run() {
        TaskHandler.postTask(new bo(this));
    }
}

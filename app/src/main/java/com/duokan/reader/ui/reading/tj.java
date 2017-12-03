package com.duokan.reader.ui.reading;

import com.duokan.core.sys.TaskHandler;

class tj implements Runnable {
    final /* synthetic */ tc a;

    tj(tc tcVar) {
        this.a = tcVar;
    }

    public void run() {
        TaskHandler.postDelayed(new tk(this), 300);
    }
}

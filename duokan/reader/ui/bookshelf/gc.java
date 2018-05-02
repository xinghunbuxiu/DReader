package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.TaskHandler;

class gc implements Runnable {
    final /* synthetic */ gb a;

    gc(gb gbVar) {
        this.a = gbVar;
    }

    public void run() {
        TaskHandler.PostTask(this.a.a);
    }
}

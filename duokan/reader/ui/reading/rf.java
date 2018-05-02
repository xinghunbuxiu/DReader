package com.duokan.reader.ui.reading;

import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.domain.bookshelf.ai;

class rf implements Runnable {
    final /* synthetic */ rc a;

    rf(rc rcVar) {
        this.a = rcVar;
    }

    public void run() {
        ai.a().a(this.a.b.f.d());
        TaskHandler.postTask(this.a.a);
    }
}

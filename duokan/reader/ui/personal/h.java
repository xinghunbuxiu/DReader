package com.duokan.reader.ui.personal;

import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;

class h implements Runnable {
    final /* synthetic */ e a;

    h(e eVar) {
        this.a = eVar;
    }

    public void run() {
        for (c cVar : ai.a().i()) {
            if (cVar.a(true)) {
                this.a.k.add(cVar);
            }
        }
        TaskHandler.postTask(new i(this));
    }
}

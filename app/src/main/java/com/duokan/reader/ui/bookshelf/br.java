package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.af;
import com.duokan.core.app.ag;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;

import java.util.List;

class br implements ag {
    final /* synthetic */ List a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ Runnable c;
    final /* synthetic */ bk d;

    br(bk bkVar, List list, Runnable runnable, Runnable runnable2) {
        this.d = bkVar;
        this.a = list;
        this.b = runnable;
        this.c = runnable2;
    }

    public void a(af afVar) {
        for (an anVar : this.a) {
            if (anVar instanceof c) {
                ((c) anVar).af();
            }
        }
        TaskHandler.postTask(this.b);
    }

    public void b(af afVar) {
        TaskHandler.postTask(this.c);
    }

    public void c(af afVar) {
        TaskHandler.postTask(this.c);
    }
}

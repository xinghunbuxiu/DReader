package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.af;
import com.duokan.core.app.ag;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.domain.bookshelf.ai;

class ik implements ag {
    final /* synthetic */ Runnable a;
    final /* synthetic */ ij b;

    ik(ij ijVar, Runnable runnable) {
        this.b = ijVar;
        this.a = runnable;
    }

    public void a(af afVar) {
        ai.a().a(true);
        TaskHandler.PostTask(this.a);
    }

    public void b(af afVar) {
        ai.a().a(false);
        TaskHandler.PostTask(this.a);
    }

    public void c(af afVar) {
    }
}

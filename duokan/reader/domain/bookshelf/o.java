package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.TaskHandler;

class o implements u {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public void a() {
        TaskHandler.postTask(new p(this));
    }

    public void b() {
        TaskHandler.postTask(new q(this));
    }

    public void c() {
        TaskHandler.postTask(new r(this));
    }
}

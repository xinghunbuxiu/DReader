package com.duokan.reader.domain.store;

import com.duokan.reader.common.classc;
import com.duokan.reader.domain.bookshelf.ai;

class p implements Runnable {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public void run() {
        this.a.c();
        classc.ConnectivityReceiver.b().a(this.a);
        ai.a().a(this.a);
    }
}

package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.classc;

class jh implements Runnable {
    final /* synthetic */ iz a;

    jh(iz izVar) {
        this.a = izVar;
    }

    public void run() {
        this.a.h();
        this.a.a(classc.ConnectivityReceiver.b());
        classc.ConnectivityReceiver.b().a(this.a.c);
    }
}

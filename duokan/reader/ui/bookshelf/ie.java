package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.kp;

class ie implements Runnable {
    final /* synthetic */ ic a;

    ie(ic icVar) {
        this.a = icVar;
    }

    public void run() {
        this.a.requestDetach();
        kp.a().f();
    }
}

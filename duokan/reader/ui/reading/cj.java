package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.c;

class cj implements Runnable {
    final /* synthetic */ ci a;

    cj(ci ciVar) {
        this.a = ciVar;
    }

    public void run() {
        c G = this.a.a.f.G();
        if (G.ai() && !G.aj()) {
            ((aaq) this.a.a.f).c();
        }
    }
}

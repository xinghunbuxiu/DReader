package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.c;

class ih implements Runnable {
    final /* synthetic */ ig a;

    ih(ig igVar) {
        this.a = igVar;
    }

    public void run() {
        c G = this.a.a.f.G();
        if (!G.ai() || G.aj()) {
            return;
        }
        if (G.U()) {
            G.aa();
        } else {
            ((ho) this.a.a.f).c();
        }
    }
}

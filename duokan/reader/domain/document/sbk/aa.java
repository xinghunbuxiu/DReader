package com.duokan.reader.domain.document.sbk;

class aa implements Runnable {
    final /* synthetic */ z a;

    aa(z zVar) {
        this.a = zVar;
    }

    public void run() {
        if (this.a.c.G()) {
            this.a.a.run();
        } else {
            this.a.b.run();
        }
    }
}

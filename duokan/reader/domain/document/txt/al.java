package com.duokan.reader.domain.document.txt;

class al implements Runnable {
    final /* synthetic */ ak a;

    al(ak akVar) {
        this.a = akVar;
    }

    public void run() {
        if (this.a.c.G()) {
            this.a.a.run();
        } else {
            this.a.b.run();
        }
    }
}

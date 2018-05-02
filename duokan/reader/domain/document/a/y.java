package com.duokan.reader.domain.document.a;

class y implements Runnable {
    final /* synthetic */ x a;

    y(x xVar) {
        this.a = xVar;
    }

    public void run() {
        if (this.a.c.G()) {
            this.a.a.run();
        } else {
            this.a.b.run();
        }
    }
}

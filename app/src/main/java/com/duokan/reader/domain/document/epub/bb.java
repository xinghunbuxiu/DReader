package com.duokan.reader.domain.document.epub;

class bb implements Runnable {
    final /* synthetic */ ba a;

    bb(ba baVar) {
        this.a = baVar;
    }

    public void run() {
        if (this.a.c.G()) {
            this.a.a.run();
        } else {
            this.a.b.run();
        }
    }
}

package com.duokan.reader.domain.bookshelf;

class eu implements Runnable {
    final /* synthetic */ es a;

    eu(es esVar) {
        this.a = esVar;
    }

    public void run() {
        this.a.a.release();
    }
}

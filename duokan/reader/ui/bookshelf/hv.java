package com.duokan.reader.ui.bookshelf;

class hv implements Runnable {
    final /* synthetic */ hu a;

    hv(hu huVar) {
        this.a = huVar;
    }

    public void run() {
        this.a.a.requestDetach();
    }
}

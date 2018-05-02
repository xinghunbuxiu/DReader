package com.duokan.reader.ui.bookshelf;

class hc implements Runnable {
    final /* synthetic */ hb a;

    hc(hb hbVar) {
        this.a = hbVar;
    }

    public void run() {
        this.a.requestDetach();
    }
}

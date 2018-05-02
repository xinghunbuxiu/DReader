package com.duokan.reader.ui.bookshelf;

class db implements Runnable {
    final /* synthetic */ cz a;

    db(cz czVar) {
        this.a = czVar;
    }

    public void run() {
        this.a.t = true;
        this.a.invalidate();
    }
}
